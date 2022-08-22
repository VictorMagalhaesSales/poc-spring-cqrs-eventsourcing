package com.victor.poc.cqrs.eventsourcing.writing.domain.event;

import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.writing.domain.enums.StatusEntrega;

import lombok.Getter;

@Getter
public class EntregaIniciadaEvent implements Evento {

	private UUID entregaId;
	private StatusEntrega status;

	public EntregaIniciadaEvent(String entregaId) {
		this.entregaId = UUID.fromString(entregaId);
		this.status = StatusEntrega.EM_ROTA;
	}

	@Override
	public String getStreamId() {
		return "entrega-"+this.getEntregaId().toString();
	}

	@Override
	public String getEventName() {
		return "ENTREGA_INICIADA";
	}

}
