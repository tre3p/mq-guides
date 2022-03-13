package com.example.demo;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSender.class);

    RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) {
        LOGGER.info("+msg(): New message received: " + msg);
        rabbitTemplate.convertAndSend("exchange", "key", msg);
        LOGGER.info("-msg(): Message was successfully sent!");
    }
}
