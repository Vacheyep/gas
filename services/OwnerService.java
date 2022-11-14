package com.example.gas.services;

import com.example.gas.model.entities.Address;
import com.example.gas.model.entities.Owner;
import com.example.gas.model.dto.OwnerDto;
import com.example.gas.exceptions.ResourceNotFoundException;
import com.example.gas.model.mappers.AddressMapper;
import com.example.gas.model.mappers.OwnerMapper;
import com.example.gas.repository.AddressRepository;
import com.example.gas.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;
    private final OwnerMapper ownerMapper;
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(AddressMapper addressMapper, AddressRepository addressRepository,
                        OwnerMapper ownerMapper, OwnerRepository ownerRepository) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
        this.ownerMapper = ownerMapper;
        this.ownerRepository = ownerRepository;
    }

    public OwnerDto createOwner(OwnerDto ownerDto){

        Optional<Owner> owner = this.ownerRepository.findOwnerByEmail(ownerDto.getEmail());
        if (owner.isEmpty()){
            throw new ResourceNotFoundException("Owner with this email is already exist");
        }

        Address addressDb1;
        Address address = addressMapper.toAddress(ownerDto.getAddressDto());
        Optional<Address> addressDb = this.addressRepository.
                findAddressByCityAndStreet(address.getCity(), address.getStreet());
        if (addressDb.isEmpty()) {
            addressDb1 = this.addressRepository.save(address);
        } else {
            addressDb1 = addressDb.get();
        }

        Owner ownerDb = this.ownerMapper.toOwner(ownerDto);
        return this.ownerMapper.toOwnerDto(this.ownerRepository.save(ownerDb));
    }
}