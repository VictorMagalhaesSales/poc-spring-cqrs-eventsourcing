package com.victor.poc.cqrs.eventsourcing.writing.handler;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.poc.cqrs.eventsourcing.writing.client.EventStoreClient;
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
	private EventStoreClient client;

	public AcompanhamentoEntregaResponse handler(SelecionarProdutoCommand command) throws Exception {
		ProdutoSelecionadoEvent evento = new ProdutoSelecionadoEvent(command);
		client.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, SelecionarEntregadorCommand command) throws Exception {
		EntregadorSelecionadoEvent evento = new EntregadorSelecionadoEvent(entregaId, command);
		client.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, IniciarEntregaCommand command) 
			throws InterruptedException, ExecutionException {
		EntregaIniciadaEvent evento = new EntregaIniciadaEvent(entregaId);
		client.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, AtualizarLocalizacaoCommand command) throws Exception {
		LocalizacaoAtualizadaEvent evento = new LocalizacaoAtualizadaEvent(entregaId, command);
		client.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, CancelarEntregaCommand command) 
			throws InterruptedException, ExecutionException {
		EntregaCanceladaEvent evento = new EntregaCanceladaEvent(entregaId);
		client.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

	public AcompanhamentoEntregaResponse handler(String entregaId, FinalizarEntregaCommand command) 
			throws InterruptedException, ExecutionException {
		EntregaFinalizadaEvent evento = new EntregaFinalizadaEvent(entregaId);
		client.publishEvent(evento);
		
		return new AcompanhamentoEntregaResponse(evento);
	}

}
