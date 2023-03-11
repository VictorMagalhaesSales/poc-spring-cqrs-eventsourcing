package com.victor.poc.cqrs.eventsourcing.writing.domain.command;

import com.victor.poc.cqrs.eventsourcing.writing.domain.model.Entregador;

import lombok.Data;

@Data
public class SelecionarEntregadorCommand {
	
	private Entregador entregador;
	private Integer messagePriority;

}
