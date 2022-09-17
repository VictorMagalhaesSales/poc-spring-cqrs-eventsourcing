package com.victor.poc.cqrs.eventsourcing.reading;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableRabbit
@EnableMongoRepositories
public class DeliveryReadingApplication {

	public static void main(String[] args) {        
		SpringApplication.run(DeliveryReadingApplication.class, args);
	}

}
