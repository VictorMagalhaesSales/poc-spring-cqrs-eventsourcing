package com.victor.poc.cqrs.eventsourcing.writing.client;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQClient {
	
    @Value("${application.messeger.sync-fanout-exchange}")
    private String syncFanoutExchange;
	
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void publishEvent(Object event) throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonMessage = mapper.writeValueAsString(event);
        rabbitTemplate.convertAndSend(syncFanoutExchange, null, jsonMessage);
    }

}


@Configuration
class RabbitMQConfig {
	
    @Value("${application.messeger.sync-queue}")
    private String syncQueueName;

	
    @Value("${application.messeger.sync-fanout-exchange}")
    private String syncFanoutExchange;

    @Bean
    public Queue syncQueue() {
        return new Queue(syncQueueName, true);
    }
    
    @Bean
    public FanoutExchange  syncFanoutExchange() {
    	return new FanoutExchange(syncFanoutExchange);
    }
    
    @Bean
    public Binding syncBinding(Queue syncQueue, FanoutExchange syncFanoutExchange) {
    	return BindingBuilder.bind(syncQueue).to(syncFanoutExchange);
    }
}


