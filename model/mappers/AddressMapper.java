package com.example.gas.model.mappers;

import com.example.gas.model.dto.AddressDto;
import com.example.gas.model.entities.Address;
import org.springframework.stereotype.Component;

@Component /* no-op */
public class AddressMapper {
    public AddressDto toAddressDto(Address address){
        return new AddressDto(address.getCity(), address.getStreet());
    }

    public Address toAddress(AddressDto addressDto){
        //return new Address(addressDto.getCity(), addressDto.getStreet())

        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        return address;
    }
}
