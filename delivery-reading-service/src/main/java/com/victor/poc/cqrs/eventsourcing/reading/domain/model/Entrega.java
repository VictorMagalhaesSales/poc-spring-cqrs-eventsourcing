package com.victor.poc.cqrs.eventsourcing.reading.domain.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.victor.poc.cqrs.eventsourcing.reading.domain.enums.StatusEntrega;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document
public class Entrega {
	
	@Id
	private UUID id;
	
	private Compra compra;
	
	private Entregador entregador;
	
	private StatusEntrega status;
	
	private Cliente cliente;
	
	private List<Checkpoint> checkpoints;
	
}
