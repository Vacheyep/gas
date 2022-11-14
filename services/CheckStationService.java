package com.example.gas.services;

import com.example.gas.model.dto.CheckStationDto;
import com.example.gas.model.entities.Address;
import com.example.gas.model.entities.CheckStation;
import com.example.gas.exceptions.DuplicateResourceException;
import com.example.gas.model.mappers.AddressMapper;
import com.example.gas.model.mappers.CheckStationMapper;
import com.example.gas.repository.AddressRepository;
import com.example.gas.repository.CheckStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckStationService {
    private final CheckStationMapper checkStationMapper;
    private final CheckStationRepository checkStationRepository;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Autowired
    public CheckStationService(CheckStationMapper checkStationMapper,
                               CheckStationRepository checkStationRepository,
                               AddressMapper addressMapper, AddressRepository addressRepository) {
        this.checkStationMapper = checkStationMapper;
        this.checkStationRepository = checkStationRepository;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }
    public CheckStationDto createCheckStation(CheckStationDto checkStationDto){
        if (this.checkStationRepository.existsBySpecialCode(checkStationDto.getSpecialCode())){
            throw new DuplicateResourceException("There is already CheckStation with this SpecialCode");
        }

        Address addressDb;
        Address address = addressMapper.toAddress(checkStationDto.getAddressDto());
        Optional<Address> addressOptional = this.addressRepository.
                findAddressByCityAndStreet(address.getCity(), address.getStreet());
        if (addressOptional.isEmpty()) {
            addressDb = this.addressRepository.save(address);
        } else {
            throw new DuplicateResourceException("There is already CheckStation with this SpecialCode");

        }
        CheckStation checkStation = checkStationMapper.toCheckStation(checkStationDto);
        checkStation.setAddress(addressDb);
        CheckStation checkStationDb = this.checkStationRepository.save(checkStation);
        return this.checkStationMapper.toCheckStationDto(checkStationDb);
    }
}
