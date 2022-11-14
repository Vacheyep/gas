package com.example.gas.model.mappers;


import com.example.gas.model.dto.CheckStationDto;
import com.example.gas.model.entities.CheckStation;
import org.springframework.stereotype.Component;

@Component
public class CheckStationMapper {

    private final AddressMapper addressMapper;

    public CheckStationMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public CheckStationDto toCheckStationDto(CheckStation checkStation){
        return new CheckStationDto(checkStation.getSpecialCode(),
                addressMapper.toAddressDto(checkStation.getAddress()));
    }

    public CheckStation toCheckStation(CheckStationDto checkStationDto){
        return new CheckStation(checkStationDto.getSpecialCode(),
                addressMapper.toAddress(checkStationDto.getAddressDto()));
    }
}
