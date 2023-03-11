package com.victor.poc.cqrs.eventsourcing.writing.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${application.messeger.sync-queue}")
    private String syncQueueName;

	
    @Value("${application.messeger.sync-fanout-exchange}")
    private String syncFanoutExchange;

    @Bean
    public Queue syncQueue() {
    	Queue queue = new Queue(syncQueueName, true);
    	queue.addArgument("x-max-priority", 5);
        return queue;
    }
    
    @Bean
    public FanoutExchange syncFanoutExchange() {
    	return new FanoutExchange(syncFanoutExchange);
    }
    
    @Bean
    public FanoutExchange syncFanoutExchange2() {
    	return new FanoutExchange(syncFanoutExchange);
    }
    
    @Bean
    public Binding syncBinding(Queue syncQueue, FanoutExchange syncFanoutExchange) {
    	return BindingBuilder.bind(syncQueue).to(syncFanoutExchange);
    }
}
