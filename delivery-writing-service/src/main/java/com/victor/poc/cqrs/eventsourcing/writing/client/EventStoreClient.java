package com.victor.poc.cqrs.eventsourcing.writing.client;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.eventstore.dbclient.EventData;
import com.eventstore.dbclient.EventStoreDBClient;
import com.eventstore.dbclient.EventStoreDBClientSettings;
import com.eventstore.dbclient.EventStoreDBConnectionString;
import com.eventstore.dbclient.EventStoreDBProjectionManagementClient;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.Evento;

@Component
public class EventStoreClient {
	
	@Autowired EventStoreDBClient client;
	
	public void publishEvent(Evento evento) throws InterruptedException, ExecutionException {;
	    EventData event = EventData
	            .builderAsJson(evento.getEventName(), evento)
	            .build();

	    client.appendToStream(evento.getStreamId(), event)
	            .get();
	}
	
}

@Configuration
class EventStoreConfig {
	
	@Bean
	EventStoreDBClient eventStoreDBClient() {
		EventStoreDBClientSettings setts = EventStoreDBConnectionString.parseOrThrow("esdb://127.0.0.1:2113?tls=false");
	    EventStoreDBClient client = EventStoreDBClient.create(setts);
	    return client;		
	}
	
	@Bean
	EventStoreDBProjectionManagementClient eventStoreDBClientProjection() {
		EventStoreDBClientSettings setts = EventStoreDBConnectionString.parseOrThrow("esdb://localhost:2113?tls=false");
		EventStoreDBProjectionManagementClient client = EventStoreDBProjectionManagementClient.create(setts);
	    return client;		
	}
}

