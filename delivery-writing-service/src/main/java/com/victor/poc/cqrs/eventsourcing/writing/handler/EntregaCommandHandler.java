package com.victor.poc.cqrs.eventsourcing.writing.handler;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.victor.poc.cqrs.eventsourcing.writing.client.EventStoreClient;
import com.victor.poc.cqrs.eventsourcing.writing.client.RabbitMQClient;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.AtualizarLocalizacaoCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.CancelarEntregaCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.FinalizarEntregaCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.IniciarEntregaCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.SelecionarEntregadorCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.SelecionarProdutoCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.EntregaCanceladaEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.EntregaFinalizadaEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.EntregaIniciadaEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.EntregadorSelecionadoEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.LocalizacaoAtualizadaEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.ProdutoSelecionadoEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.response.AcompanhamentoEntregaResponse;

@Service
public class EntregaCommandHandler {
	
	@Autowired
	private EventStoreClient eventStoreClient;
	@Autowired
	private RabbitMQClient rabbitMqClient;

	public AcompanhamentoEntregaResponse handler(SelecionarProdutoCommand command) throws Exception {
		ProdutoSelecionadoEvent evento = new ProdutoSelecionadoEvent(command);
		eventStoreClient.publishEvent(evento);
		rabbitMqClient.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, SelecionarEntregadorCommand command) throws Exception {
		EntregadorSelecionadoEvent evento = new EntregadorSelecionadoEvent(entregaId, command);
		eventStoreClient.publishEvent(evento);
		rabbitMqClient.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, IniciarEntregaCommand command) 
			throws InterruptedException, ExecutionException, JsonProcessingException {
		EntregaIniciadaEvent evento = new EntregaIniciadaEvent(entregaId);
		eventStoreClient.publishEvent(evento);
		rabbitMqClient.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, AtualizarLocalizacaoCommand command) throws Exception {
		LocalizacaoAtualizadaEvent evento = new LocalizacaoAtualizadaEvent(entregaId, command);
		eventStoreClient.publishEvent(evento);
		rabbitMqClient.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, CancelarEntregaCommand command) 
			throws InterruptedException, ExecutionException, JsonProcessingException {
		EntregaCanceladaEvent evento = new EntregaCanceladaEvent(entregaId);
		eventStoreClient.publishEvent(evento);
		rabbitMqClient.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, FinalizarEntregaCommand command) 
			throws InterruptedException, ExecutionException, JsonProcessingException {
		EntregaFinalizadaEvent evento = new EntregaFinalizadaEvent(entregaId);
		eventStoreClient.publishEvent(evento);
		rabbitMqClient.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

}
