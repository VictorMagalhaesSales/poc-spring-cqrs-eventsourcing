package com.victor.poc.cqrs.eventsourcing.reading.domain.event;

import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.reading.domain.enums.StatusEntrega;
import com.victor.poc.cqrs.eventsourcing.reading.domain.model.Cliente;
import com.victor.poc.cqrs.eventsourcing.reading.domain.model.Compra;

import lombok.Getter;

@Getter
public class ProdutoSelecionadoEvent {

	private UUID entregaId;
	private Compra compra;
	private Cliente cliente;
	private StatusEntrega status;

}
