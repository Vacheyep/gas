package com.example.gas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
    private AddressDto addressDto;

}
