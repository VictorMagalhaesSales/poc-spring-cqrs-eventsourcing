package com.victor.poc.cqrs.eventsourcing.reading.client;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQClient {
	
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String event) {
        rabbitTemplate.convertAndSend(this.queue.getName(), event);
    }

}


@Configuration
class RabbitMQConfig {
	
    @Value("${application.messeger.sync-queue}")
    private String queueName;

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }
}


