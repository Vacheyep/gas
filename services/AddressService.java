package com.example.gas.services;

import com.example.gas.model.entities.Address;
import com.example.gas.model.dto.AddressDto;
import com.example.gas.exceptions.DuplicateResourceException;
import com.example.gas.exceptions.ResourceNotFoundException;
import com.example.gas.model.mappers.AddressMapper;
import com.example.gas.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressMapper addressMapper, AddressRepository addressRepository) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    public static List<Address> getData() {
        return null;
    }

    public AddressDto createAddress(AddressDto addressDto){
        Optional<Address> address = this.addressRepository.
                findAddressByCityAndStreet(addressDto.getCity(),addressDto.getStreet());
        if (address.isPresent()){
            throw new DuplicateResourceException("There is already such address ");
        }
        this.addressRepository.save(addressMapper.toAddress(addressDto));
        return addressDto;
    }

//    public AddressDto createOwnerAddress(AddressDto addressDto){
//        Optional<Address> address = this.addressRepository.
//                findAddressByCityAndStreet(addressDto.getCity(),addressDto.getStreet());
//
//        this.addressRepository.save(addressMapper.toAddress(addressDto));
//        return addressDto;
//    }

    public void deleteAddress(AddressDto addressDto){
        Optional<Address> address = this.addressRepository.
                findAddressByCityAndStreet(addressDto.getCity(),addressDto.getStreet());
        if (address.isEmpty()){
            throw new ResourceNotFoundException("There isn't such address ");
        }
        this.addressRepository.delete(addressMapper.toAddress(addressDto));
    }
}
