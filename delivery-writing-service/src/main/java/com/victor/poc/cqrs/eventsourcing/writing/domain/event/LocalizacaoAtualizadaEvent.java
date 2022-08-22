package com.victor.poc.cqrs.eventsourcing.writing.domain.event;

import java.util.Date;
import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.writing.domain.command.AtualizarLocalizacaoCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.enums.StatusEntrega;
import com.victor.poc.cqrs.eventsourcing.writing.domain.model.Endereco;

import lombok.Getter;

@Getter
public class LocalizacaoAtualizadaEvent implements Evento {

	private UUID entregaId;
	private StatusEntrega status;
	private Endereco localizacaoAtual;
	private Date dataAtualizacao;

	public LocalizacaoAtualizadaEvent(String entregaId, AtualizarLocalizacaoCommand command) throws Exception {
		this.entregaId = UUID.fromString(entregaId);
		this.status = StatusEntrega.EM_ROTA;
		this.dataAtualizacao = new Date();
		if(localizacaoIsValid(command)) {
			this.localizacaoAtual = command.getLocalizacaoAtual();			
		}
	}

	private Boolean localizacaoIsValid(AtualizarLocalizacaoCommand command) throws Exception {
		if(command.getLocalizacaoAtual() == null) {
			throw new Exception("A localização atual deve ser informada");
		}
		return true;
	}

	@Override
	public String getStreamId() {
		return "entrega-"+this.getEntregaId().toString();
	}

	@Override
	public String getEventName() {
		return "LOCALIZACAO_ATUALIZADA";
	}
}
