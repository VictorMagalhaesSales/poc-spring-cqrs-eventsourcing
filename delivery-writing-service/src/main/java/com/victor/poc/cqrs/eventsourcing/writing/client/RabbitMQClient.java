package com.victor.poc.cqrs.eventsourcing.writing.client;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


    public void publishEventWithPriority(Object event, int priority) throws JsonProcessingException {
    	MessagePostProcessor messagePostProcessor = message -> {
    	    message.getMessageProperties().setPriority(priority);
    	    return message;
    	};
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonMessage = mapper.writeValueAsString(event);
        rabbitTemplate. convertAndSend(syncFanoutExchange, null, jsonMessage, messagePostProcessor);
    }

}