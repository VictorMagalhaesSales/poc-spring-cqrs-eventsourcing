package com.victor.poc.cqrs.eventsourcing.reading.domain.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Checkpoint {
	
	private Endereco endereco;
	
	private Date data;

}
