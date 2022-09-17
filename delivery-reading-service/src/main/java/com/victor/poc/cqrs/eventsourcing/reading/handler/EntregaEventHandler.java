package com.victor.poc.cqrs.eventsourcing.reading.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregaCanceladaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregaFinalizadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregaIniciadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.EntregadorSelecionadoEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.LocalizacaoAtualizadaEvent;
import com.victor.poc.cqrs.eventsourcing.reading.domain.event.ProdutoSelecionadoEvent;
import com.victor.poc.cqrs.eventsourcing.reading.repository.EntregaRepository;

@Component
public class EntregaEventHandler {
	
	@Autowired
	private EntregaRepository repository;
	
    public void handler(ProdutoSelecionadoEvent event) {
    	System.out.println("ProdutoSelecionadoEvent");
	}

    public void handler(EntregadorSelecionadoEvent event) {
    	System.out.println("EntregadorSelecionadoEvent");
    }

    public void handler(EntregaCanceladaEvent event) {
    	System.out.println("EntregaCanceladaEvent");
    }

    public void handler(EntregaFinalizadaEvent event) {
    	System.out.println("EntregaFinalizadaEvent");
    }

    public void handler(EntregaIniciadaEvent event) {
    	System.out.println("EntregaIniciadaEvent");
    }

    public void handler(LocalizacaoAtualizadaEvent event) {
    	System.out.println("LocalizacaoAtualizadaEvent");
    }
}
