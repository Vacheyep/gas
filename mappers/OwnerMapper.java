package com.example.gas.mappers;

import com.example.gas.dto.OwnerDto;
import com.example.gas.entities.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    private final AddressMapper addressMapper;

    public OwnerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }


    public OwnerDto toOwnerDto(Owner owner){
        return new OwnerDto(owner.getName(),owner.getSurname(),owner.getEmail(),
                addressMapper.toAddressDto(owner.getAddress()));
    }

    public Owner toOwner(OwnerDto ownerDto){
        return new Owner(ownerDto.getName(),ownerDto.getSurname(),ownerDto.getEmail(),
                addressMapper.toAddress(ownerDto.getAddressDto()));
    }
}
