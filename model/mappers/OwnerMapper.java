package com.example.gas.model.mappers;

import com.example.gas.model.entities.Owner;
import com.example.gas.model.dto.OwnerDto;
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
