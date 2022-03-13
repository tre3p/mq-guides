package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createNewUser(UserDto userDto) {
        return userRepository.save(
                new User(userDto.getFirstName(),
                        userDto.getLastName())
        );
    }
}
