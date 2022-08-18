package com.example.gas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ValidateCylinderDto {

    @NotNull
    @Size(min = 5, max = 12)
    private String carNumber;
    @NotNull
    @Size(min = 2 ,max = 20)
    private String cylinderNumber;
    @NotNull
    private Date verificationDate;
    @NotNull
    private OwnerDto ownerDto;
}
