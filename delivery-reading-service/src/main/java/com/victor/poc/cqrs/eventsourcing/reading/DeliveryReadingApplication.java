package com.victor.poc.cqrs.eventsourcing.reading;


import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DeliveryReadingApplication {

	public static void main(String[] args) {        
		SpringApplication.run(DeliveryReadingApplication.class, args);
	}

}
