package com.example.gas.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CylinderDto {
    @NotNull
    private String carNumber;
    @NotNull
    private String cylinderNumber;
    @NotNull
    private Date verificationDate;
    @NotNull
    private OwnerDto ownerDto;
}
