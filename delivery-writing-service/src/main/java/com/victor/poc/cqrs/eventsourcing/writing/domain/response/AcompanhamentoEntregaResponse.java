package com.victor.poc.cqrs.eventsourcing.writing.domain.response;

import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.writing.domain.enums.StatusEntrega;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.EntregaCanceladaEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.EntregaFinalizadaEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.EntregaIniciadaEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.EntregadorSelecionadoEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.LocalizacaoAtualizadaEvent;
import com.victor.poc.cqrs.eventsourcing.writing.domain.event.ProdutoSelecionadoEvent;

import lombok.Data;

@Data
public class AcompanhamentoEntregaResponse {
	
	private UUID entregaId;
	private StatusEntrega status;
	
	public AcompanhamentoEntregaResponse(ProdutoSelecionadoEvent evento) {
		this.entregaId = evento.getEntregaId();
		this.status = evento.getStatus();
	}

	public AcompanhamentoEntregaResponse(EntregadorSelecionadoEvent evento) {
		this.entregaId = evento.getEntregaId();
		this.status = evento.getStatus();
	}

	public AcompanhamentoEntregaResponse(EntregaIniciadaEvent evento) {
		this.entregaId = evento.getEntregaId();
		this.status = evento.getStatus();
	}

	public AcompanhamentoEntregaResponse(LocalizacaoAtualizadaEvent evento) {
		this.entregaId = evento.getEntregaId();
		this.status = evento.getStatus();
	}

	public AcompanhamentoEntregaResponse(EntregaCanceladaEvent evento) {
		this.entregaId = evento.getEntregaId();
		this.status = evento.getStatus();
	}

	public AcompanhamentoEntregaResponse(EntregaFinalizadaEvent evento) {
		this.entregaId = evento.getEntregaId();
		this.status = evento.getStatus();
	}

}
