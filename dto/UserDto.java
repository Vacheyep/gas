package com.example.gas.dto;

import com.example.gas.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    @NotNull
    private Role role;
}
