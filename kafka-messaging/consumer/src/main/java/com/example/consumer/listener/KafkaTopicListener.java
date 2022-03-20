package com.example.consumer.listener;

import com.example.consumer.dto.UserDto;
import com.example.consumer.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaTopicListener {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper om;


    @KafkaListener(topics = "user")
    public void queueListener(ConsumerRecord<Long, String> consumerRecord) throws JsonProcessingException {
        UserDto userDto = om.readValue(consumerRecord.value(), UserDto.class);
        log.info("CONSUMER: +queueListener(): User with firstName {} was received", userDto.getFirstName());
        userService.registerNewUser(userDto);
        log.info("CONSUMER: -queueListener(): User has been successfully registered!");
    }
}
