package com.victor.poc.cqrs.eventsourcing.writing.domain.command;

import com.victor.poc.cqrs.eventsourcing.writing.domain.model.Endereco;

import lombok.Data;

@Data
public class AtualizarLocalizacaoCommand {

	private Endereco localizacaoAtual;
	
}
