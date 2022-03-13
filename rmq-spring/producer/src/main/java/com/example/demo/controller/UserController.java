package com.example.demo.controller;

import com.example.demo.MessageSender;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;
    private MessageSender messageSender;
    private UserService userService;

    @GetMapping
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createNewUser(@RequestBody UserDto userDto) {
        User user = userService.createNewUser(userDto);
        String msg = "User with name " + user.getFirstName() + " was successfully registered!";
        messageSender.sendMessage(msg);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        User userToDelete = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        String msg = "User with name " + userToDelete.getFirstName() + " was successfully deleted!";
        messageSender.sendMessage(msg);
    }
}
