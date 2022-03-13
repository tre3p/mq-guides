package com.example.consumer.controller;

import com.example.consumer.QueueListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    QueueListener queueListener;

    @GetMapping
    public List<String> getAllMessages() {
        return queueListener.getAllMessages();
    }
}
