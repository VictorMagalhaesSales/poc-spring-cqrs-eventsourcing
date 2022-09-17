package com.victor.poc.cqrs.eventsourcing.reading.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Produto {

	private String nome;
	
	private BigDecimal preco;
	
}
