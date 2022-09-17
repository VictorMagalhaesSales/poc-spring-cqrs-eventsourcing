package com.victor.poc.cqrs.eventsourcing.writing.domain.command;

import com.victor.poc.cqrs.eventsourcing.writing.domain.model.Cliente;
import com.victor.poc.cqrs.eventsourcing.writing.domain.model.Compra;

import lombok.Data;

@Data
public class FinalizarCompraCommand {
	
	private Compra compra;
	private Cliente cliente;

}
