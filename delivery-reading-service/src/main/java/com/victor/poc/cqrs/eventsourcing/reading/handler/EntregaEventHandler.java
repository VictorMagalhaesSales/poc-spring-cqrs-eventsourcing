package com.victor.poc.cqrs.eventsourcing.reading.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.victor.poc.cqrs.eventsourcing.reading.domain.event.CompraFinalizadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregaCanceladaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregaFinalizadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregaIniciadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregadorSelecionadoEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.LocalizacaoAtualizadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.model.Checkpoint;
import com.victor.poc.cqrs.eventsourcing.reading.domain.model.Entrega;
import com.victor.poc.cqrs.eventsourcing.reading.repository.EntregaRepository;

@Component
public class EntregaEventHandler {
	
	@Autowired
	private EntregaRepository repository;
	
    public void handler(CompraFinalizadaEvent event) {
    	Entrega entrega = Entrega.builder()
    			.id(event.getEntregaId())
    			.compra(event.getCompra())
    			.cliente(event.getCliente())
    			.status(event.getStatus())
    			.build();
    	
    	this.repository.save(entrega);
	}

    public void handler(EntregadorSelecionadoEvent event) {
    	Entrega entrega = this.repository.findById(event.getEntregaId()).orElseThrow();
    	entrega.setStatus(event.getStatus());
    	entrega.setEntregador(event.getEntregador());
    	
    	this.repository.save(entrega);
    }

    public void handler(EntregaIniciadaEvent event) {
    	Entrega entrega = this.repository.findById(event.getEntregaId()).orElseThrow();
    	entrega.setStatus(event.getStatus());
    	
    	this.repository.save(entrega);
    }

    public void handler(LocalizacaoAtualizadaEvent event) {
    	Entrega entrega = this.repository.findById(event.getEntregaId()).orElseThrow();
    	entrega.setStatus(event.getStatus());
    	
    	Checkpoint checkpoint = Checkpoint.builder()
    			.endereco(event.getLocalizacao())
    			.data(event.getDataAtualizacao())
    			.build();
    	
    	if(entrega.getCheckpoints() != null) {
        	entrega.getCheckpoints().add(checkpoint);
    	} else {
    		entrega.setCheckpoints(List.of(checkpoint));
    	}
    	
    	
    	this.repository.save(entrega);
    }

    public void handler(EntregaCanceladaEvent event) {
    	Entrega entrega = this.repository.findById(event.getEntregaId()).orElseThrow();
    	entrega.setStatus(event.getStatus());
    	
    	this.repository.save(entrega);
    }

    public void handler(EntregaFinalizadaEvent event) {
    	Entrega entrega = this.repository.findById(event.getEntregaId()).orElseThrow();
    	entrega.setStatus(event.getStatus());
    	
    	this.repository.save(entrega);
    }
}
