package com.victor.poc.cqrs.eventsourcing.reading.domain.model;

import lombok.Data;

@Data
public class Endereco {

	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	
}
