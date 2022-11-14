package com.example.gas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class CheckCylinderDto {

    @NotNull
    @Size(min = 5, max = 12)
    private String carNumber;
    @NotNull
    @Size(min = 2 ,max = 20)
    private String cylinderNumber;
}
