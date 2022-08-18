package com.example.gas.dto;

import com.example.gas.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class CheckStationDto {

    @NotNull
    @Size(min = 3,max = 10)
    private String specialCode;
    @NotNull
    @Size(min = 3,max = 45)
    private AddressDto addressDto;
}
