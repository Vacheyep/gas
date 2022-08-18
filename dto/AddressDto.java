package com.example.gas.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class AddressDto {

    @NotNull
    @Size(min = 3,max = 45)
    private String city;

    @NotNull
    @Size(min = 3,max = 45)
    private String street;

}
