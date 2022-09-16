package com.victor.poc.cqrs.eventsourcing.reading.domain.event;

import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.reading.domain.enums.StatusEntrega;
import com.victor.poc.cqrs.eventsourcing.reading.domain.model.Entregador;

import lombok.Getter;

@Getter
public class EntregadorSelecionadoEvent implements Evento {

	private UUID entregaId;
	private Entregador entregador;
	private StatusEntrega status;

	@Override
	public String getEventName() {
		return "ENTREGADOR_SELECIONADO";
	}
}
