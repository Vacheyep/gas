package com.example.gas.model.dto;

import com.example.gas.model.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    @Email
    @Size(min = 10,max = 45)
    @NotNull
    private String email;
    @Size(min = 8,max = 45)
    @NotNull
    private String password;
    @NotNull
    private Role role;
}
