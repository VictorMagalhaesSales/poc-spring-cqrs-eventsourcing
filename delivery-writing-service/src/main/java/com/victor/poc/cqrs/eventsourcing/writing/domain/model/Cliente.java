package com.victor.poc.cqrs.eventsourcing.writing.domain.model;

import lombok.Data;

@Data
public class Cliente {
	
	private String nome;
	private String telefone;
	private Endereco endereco;

}
