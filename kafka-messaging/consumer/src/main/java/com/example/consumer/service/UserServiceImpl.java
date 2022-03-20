package com.example.consumer.service;

import com.example.consumer.dto.UserDto;
import com.example.consumer.model.User;
import com.example.consumer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerNewUser(UserDto userDto) {
        log.debug("+registerNewUser()");
        User newUser = userRepository.save(new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getAddress().toAddress()
        ));
        log.debug("-registerNewUser(): User has been successfully registered!");
        return newUser;
    }
}
