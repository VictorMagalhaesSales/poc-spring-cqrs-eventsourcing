package com.victor.poc.cqrs.eventsourcing.reading.domain.event;

import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.reading.domain.enums.StatusEntrega;

import lombok.Getter;

@Getter
public class EntregaFinalizadaEvent implements Evento {

	private UUID entregaId;
	private StatusEntrega status;

	@Override
	public String getEventName() {
		return "ENTREGA_FINALIZADA";
	}
}
