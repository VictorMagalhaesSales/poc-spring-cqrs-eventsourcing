package com.victor.poc.cqrs.eventsourcing.writing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.poc.cqrs.eventsourcing.writing.domain.command.AtualizarLocalizacaoCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.CancelarEntregaCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.FinalizarEntregaCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.IniciarEntregaCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.SelecionarEntregadorCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.command.SelecionarProdutoCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.response.AcompanhamentoEntregaResponse;
import com.victor.poc.cqrs.eventsourcing.writing.handler.EntregaCommandHandler;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaCommandHandler entregaCommandHandler;
	
	@PostMapping("/loja/produto")
	public ResponseEntity<AcompanhamentoEntregaResponse> selecionarProduto(@RequestBody SelecionarProdutoCommand command) throws Exception {
		
		AcompanhamentoEntregaResponse resp = this.entregaCommandHandler.handler(command);
		return ResponseEntity.created(null).body(resp);
	}
	
	@PostMapping("/{entregaId}/entregador")
	public ResponseEntity<AcompanhamentoEntregaResponse> selecionarEntregador(
			@PathVariable String entregaId,
			@RequestBody SelecionarEntregadorCommand command) throws Exception {
		
		AcompanhamentoEntregaResponse resp = this.entregaCommandHandler.handler(entregaId, command);
		return ResponseEntity.created(null).body(resp);
	}
	
	@PatchMapping(path = "/{entregaId}", params = "iniciarEntrega")
	public ResponseEntity<AcompanhamentoEntregaResponse> iniciarEntrega(
			@PathVariable String entregaId,
			@RequestBody IniciarEntregaCommand command) throws Exception {
		
		AcompanhamentoEntregaResponse resp = this.entregaCommandHandler.handler(entregaId, command);
		return ResponseEntity.created(null).body(resp);
	}
	
	@PatchMapping(path = "/{entregaId}", params = "atualizarLocalizacao")
	public ResponseEntity<AcompanhamentoEntregaResponse> atualizarLocalizacao(
			@PathVariable String entregaId,
			@RequestBody AtualizarLocalizacaoCommand command) throws Exception {
		
		AcompanhamentoEntregaResponse resp = this.entregaCommandHandler.handler(entregaId, command);
		return ResponseEntity.created(null).body(resp);
	}
	
	@PatchMapping(path = "/{entregaId}", params = "cancelarEntrega")
	public ResponseEntity<AcompanhamentoEntregaResponse> cancelarEntrega(
			@PathVariable String entregaId,
			@RequestBody CancelarEntregaCommand command) throws Exception {
		
		AcompanhamentoEntregaResponse resp = this.entregaCommandHandler.handler(entregaId, command);
		return ResponseEntity.created(null).body(resp);
	}
	
	@PatchMapping(path = "/{entregaId}", params = "finalizarEntrega")
	public ResponseEntity<AcompanhamentoEntregaResponse> finalizarEntrega(
			@PathVariable String entregaId,
			@RequestBody FinalizarEntregaCommand command) throws Exception {
		
		AcompanhamentoEntregaResponse resp = this.entregaCommandHandler.handler(entregaId, command);
		return ResponseEntity.created(null).body(resp);
	}

}
