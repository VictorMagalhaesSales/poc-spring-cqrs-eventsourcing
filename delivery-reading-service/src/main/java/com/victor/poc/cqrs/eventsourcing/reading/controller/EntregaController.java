package com.victor.poc.cqrs.eventsourcing.reading.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.poc.cqrs.eventsourcing.reading.domain.model.Entrega;
import com.victor.poc.cqrs.eventsourcing.reading.repository.EntregaRepository;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaRepository repository;
	

	@GetMapping("/{idEntrega}")
	public ResponseEntity<Entrega> consultarEntrega(@PathVariable String idEntrega) {
		
		Entrega entrega = this.repository.findById(UUID.fromString(idEntrega)).orElseThrow();
		
		return ResponseEntity.ok(entrega);
	}
	
}
