package com.victor.poc.cqrs.eventsourcing.reading.handler;

import java.util.HashMap;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregaCanceladaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregaFinalizadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregaIniciadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregadorSelecionadoEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.LocalizacaoAtualizadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.CompraFinalizadaEvent;

@Component
public class EntregaEventConsumer {
	
	@Autowired
	private EntregaEventHandler handler;

	
    @RabbitListener(queues = {"${application.messeger.sync-queue}"})
    public void receive(@Payload String message) throws JsonMappingException, JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	
    	switch(getEventName(message, mapper)) {

			case "COMPRA_FINALIZADA": 
				CompraFinalizadaEvent produtoSelecionadoEvent = mapper.readValue(message, CompraFinalizadaEvent.class);
				handler.handler(produtoSelecionadoEvent);
				break;
				
			case "ENTREGADOR_SELECIONADO": 
				EntregadorSelecionadoEvent entregadorSelecionadoEvent = mapper.readValue(message, EntregadorSelecionadoEvent.class);
				handler.handler(entregadorSelecionadoEvent);
				break;
				
			case "ENTREGA_INICIADA": 
				EntregaIniciadaEvent entregaIniciadaEvent = mapper.readValue(message, EntregaIniciadaEvent.class);
				handler.handler(entregaIniciadaEvent);
				break;
				
			case "LOCALIZACAO_ATUALIZADA": 
				LocalizacaoAtualizadaEvent localizacaoAtualizadaEvent = mapper.readValue(message, LocalizacaoAtualizadaEvent.class);
				handler.handler(localizacaoAtualizadaEvent);
				break;
			
			case "ENTREGA_CANCELADA": 
				EntregaCanceladaEvent entregaCanceladaEvent = mapper.readValue(message, EntregaCanceladaEvent.class);
				handler.handler(entregaCanceladaEvent);
				break;
				
			case "ENTREGA_FINALIZADA": 
				EntregaFinalizadaEvent entregaFinalizadaEvent = mapper.readValue(message, EntregaFinalizadaEvent.class);
				handler.handler(entregaFinalizadaEvent);
				break;
    	}
    }


	private String getEventName(String message, ObjectMapper mapper)
			throws JsonProcessingException, JsonMappingException {
		HashMap<String, String> map = mapper.readValue(message, HashMap.class);
    	String eventName = map.get("eventName");
		return eventName;
	}
}
