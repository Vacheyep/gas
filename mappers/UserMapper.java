package com.example.gas.mappers;

import com.example.gas.dto.UserDto;
import com.example.gas.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserDto userDto){
        return new User(userDto.getRole());
    }

    public UserDto toUserDto(User user){
        return new UserDto(user.getRole());
    }
}
