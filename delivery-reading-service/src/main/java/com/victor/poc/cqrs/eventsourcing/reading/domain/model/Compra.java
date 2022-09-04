package com.victor.poc.cqrs.eventsourcing.reading.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class Compra {

	private String nomeLoja;
	private Endereco enderecoLoja;
	private List<Produto> produtos;
	
}
