package com.victor.poc.cqrs.eventsourcing.reading.domain.event;

import java.util.Date;
import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.reading.domain.enums.StatusEntrega;
import com.victor.poc.cqrs.eventsourcing.reading.domain.model.Endereco;

import lombok.Getter;

@Getter
public class LocalizacaoAtualizadaEvent implements Evento {

	private UUID entregaId;
	private StatusEntrega status;
	private Endereco localizacao;
	private Date dataAtualizacao;

	@Override
	public String getEventName() {
		return "LOCALIZACAO_ATUALIZADA";
	}
}
