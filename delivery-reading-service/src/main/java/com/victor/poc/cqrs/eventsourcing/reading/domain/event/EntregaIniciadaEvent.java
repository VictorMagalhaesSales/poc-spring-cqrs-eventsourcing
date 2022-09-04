package com.victor.poc.cqrs.eventsourcing.reading.domain.event;

import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.reading.domain.enums.StatusEntrega;

import lombok.Getter;

@Getter
public class EntregaIniciadaEvent {

	private UUID entregaId;
	private StatusEntrega status;

}
