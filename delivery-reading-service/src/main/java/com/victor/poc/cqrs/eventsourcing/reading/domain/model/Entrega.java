package com.victor.poc.cqrs.eventsourcing.reading.domain.model;

import java.util.Date;
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
	
	private StatusEntrega status;
	private Endereco localizacaoAtual;
	private Date ultimaAtualizacao;
	
	private Entregador entregador;
	private Produto produto;
	private Cliente cliente;

}
