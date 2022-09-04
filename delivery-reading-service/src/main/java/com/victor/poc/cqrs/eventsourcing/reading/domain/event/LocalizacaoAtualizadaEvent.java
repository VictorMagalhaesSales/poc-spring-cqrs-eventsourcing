package com.victor.poc.cqrs.eventsourcing.reading.domain.event;

import java.util.Date;
import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.reading.domain.enums.StatusEntrega;
import com.victor.poc.cqrs.eventsourcing.reading.domain.model.Endereco;

import lombok.Getter;

@Getter
public class LocalizacaoAtualizadaEvent {

	private UUID entregaId;
	private StatusEntrega status;
	private Endereco localizacaoAtual;
	private Date dataAtualizacao;

}
