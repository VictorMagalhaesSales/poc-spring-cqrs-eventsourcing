package com.victor.poc.cqrs.eventsourcing.writing.domain.event;

import java.util.UUID;

import com.victor.poc.cqrs.eventsourcing.writing.domain.command.SelecionarProdutoCommand;
import com.victor.poc.cqrs.eventsourcing.writing.domain.enums.StatusEntrega;
import com.victor.poc.cqrs.eventsourcing.writing.domain.model.Cliente;
import com.victor.poc.cqrs.eventsourcing.writing.domain.model.Compra;

import lombok.Getter;

@Getter
public class ProdutoSelecionadoEvent implements Evento {

	private UUID entregaId;
	private Compra compra;
	private Cliente cliente;
	private StatusEntrega status;
	
	public ProdutoSelecionadoEvent(SelecionarProdutoCommand command) throws Exception {
		this.entregaId = UUID.randomUUID();
		this.status = StatusEntrega.ABERTA;
		if(compraIsValid(command)) {
			this.compra = command.getCompra();
		}
		if(enderecoIsValid(command)) {
			this.cliente = command.getCliente();
		}
	}

	private Boolean enderecoIsValid(SelecionarProdutoCommand command) throws Exception {
		if(command.getCliente().getEndereco() == null) {
			throw new Exception("O endereço do cliente não pode estar vazio");
		} else if(command.getCliente().getNome() == null) {
			throw new Exception("O nome do cliente não pode estar vazio");
		}
		return true;
	}

	private Boolean compraIsValid(SelecionarProdutoCommand command) throws Exception {
		if(command.getCompra() == null) {
			throw new Exception("A compra não pode estar vazia");
		} else if(command.getCompra().getEnderecoLoja() == null) {
			throw new Exception("O endereço da loja não pode estar vazio");
		} else if(command.getCompra().getProdutos() == null || command.getCompra().getProdutos().isEmpty()) {
			throw new Exception("É necessário selecionar pelo menos um produto");
		} else if(command.getCompra().getNomeLoja() == null) {
			throw new Exception("O nome da loja não pode estar vazio");
		}
		return true;
	}

	@Override
	public String getStreamId() {
		return "entrega-"+this.getEntregaId().toString();
	}

	@Override
	public String getEventName() {
		return "PRODUTO_SELECIONADO";
	}

}
