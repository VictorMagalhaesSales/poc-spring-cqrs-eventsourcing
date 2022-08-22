package com.victor.poc.cqrs.eventsourcing.reading.handler;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EntregaEventHandler {

    @RabbitListener(queues = {"${application.messeger.sync-queue}"})
    public void receive(@Payload String fileBody) {
        System.out.println("Message: " + fileBody);
    }
}
