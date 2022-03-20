package com.example.producer.controller;

import com.example.producer.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    KafkaTemplate<Long, String> kafkaTemplate;

    @PostMapping
    public void registerNewUser(@RequestBody String userDto) {
        log.debug("PRODUCER: +registerNewUser()");
        kafkaTemplate.send("user", userDto);
        log.debug("PRODUCER: -registerNewUser()");
    }
}
