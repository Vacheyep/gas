package com.example.gas.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class OwnerDto {
    @NotNull
    @Size(min = 2, max = 45)
    private String name;
    @NotNull
    @Size(min = 2, max = 45)
    private String surname;
    @NotNull
    private String email;

    private AddressDto addressDto;


}
