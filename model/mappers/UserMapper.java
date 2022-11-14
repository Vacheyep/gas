package com.example.gas.model.mappers;

import com.example.gas.model.dto.UserDto;
import com.example.gas.model.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserDto userDto){
        return new User(userDto.getEmail(),userDto.getPassword(),userDto.getRole());
    }

    public UserDto toUserDto(User user){
        return new UserDto(user.getEmail(), user.getPassword(), user.getRole());
    }
}
