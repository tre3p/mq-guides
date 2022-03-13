package com.example.demo.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Bean
    Queue queue() {
        return new Queue("queue", false);
    }

    @Bean
    TopicExchange topic() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bind(Queue queue, TopicExchange topic) {
        return BindingBuilder.bind(queue).to(topic).with("key");
    }
}
