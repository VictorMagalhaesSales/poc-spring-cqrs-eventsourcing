package com.victor.poc.cqrs.eventsourcing.reading.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Checkpoint {
	
	private Endereco endereco;
	
	private Date data;

}
