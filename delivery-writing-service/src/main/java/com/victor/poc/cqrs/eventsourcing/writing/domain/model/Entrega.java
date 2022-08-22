package com.victor.poc.cqrs.eventsourcing.writing.domain.model;

import java.util.Date;
import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.writing.domain.enums.StatusEntrega;

import lombok.Data;

@Data
public class Entrega {
	
	private UUID id;
	private StatusEntrega status;
	private Endereco localizacaoAtual;
	private Date ultimaAtualizacao;
	
	private Entregador entregador;
	private Produto produto;
	private Cliente cliente;

}
