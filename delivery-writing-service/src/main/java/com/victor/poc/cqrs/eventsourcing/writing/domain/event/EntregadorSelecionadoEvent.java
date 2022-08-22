package com.victor.poc.cqrs.eventsourcing.writing.domain.event;

import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.writing.domain.command.SelecionarEntregadorCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.enums.StatusEntrega;
import com.victor.poc.cqrs.eventsourcing.writing.domain.model.Entregador;

import lombok.Getter;

@Getter
public class EntregadorSelecionadoEvent implements Evento{

	private UUID entregaId;
	private Entregador entregador;
	private StatusEntrega status;
	
	public EntregadorSelecionadoEvent(String entregaId, SelecionarEntregadorCommand command) throws Exception {
		this.entregaId = UUID.fromString(entregaId);
		this.status = StatusEntrega.AGUARDANDO_ENTREGADOR;
		if(entregadorIsValid(command)) {
			this.entregador = command.getEntregador();			
		}
	}

	private Boolean entregadorIsValid(SelecionarEntregadorCommand command) throws Exception {
		if(command.getEntregador().getNome() == null) {
			throw new Exception("O nome do entregador não pode ser nulo");
		} else if(command.getEntregador().getVeiculo() == null) {
			throw new Exception("O veículo do entregador não pode ser nulo");
		}
		return true;
	}

	@Override
	public String getStreamId() {
		return "entrega-"+this.getEntregaId().toString();
	}

	@Override
	public String getEventName() {
		return "ENTREGADOR_SELECIONADO";
	}

}
