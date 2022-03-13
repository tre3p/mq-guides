package com.example.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueueListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(QueueListener.class);

    private List<String> messages = new ArrayList<>();

    public List<String> getAllMessages() {
        return messages;
    }

    @RabbitListener(queues = "queue")
    public void processMessages(String msg) {
        LOGGER.info("+processMessages(): Message was received: " + msg);
        messages.add(msg);
    }
}
