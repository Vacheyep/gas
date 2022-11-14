package com.example.gas.services;

import com.example.gas.model.dto.UserDto;
import com.example.gas.model.entities.User;
import com.example.gas.exceptions.DuplicateResourceException;
import com.example.gas.model.mappers.UserMapper;
import com.example.gas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public UserDto createUser(UserDto userDto){
        if (this.userRepository.existsByEmail(userDto.getEmail())) {
            throw new DuplicateResourceException("There is already user with this email ");
        }
        PasswordEncoder pe = new BCryptPasswordEncoder();
        User user = userMapper.toUser(userDto);
        user.setPassword(pe.encode(user.getPassword()));
        User userDb = this.userRepository.save(user);
        return this.userMapper.toUserDto(userDb);
    }

}
