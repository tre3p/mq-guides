package com.example.consumer.service;

import com.example.consumer.dto.UserDto;
import com.example.consumer.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User registerNewUser(UserDto userDto);
}
