package com.victor.poc.cqrs.eventsourcing.reading.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.victor.poc.cqrs.eventsourcing.reading.domain.model.Entrega;

@Repository
public interface EntregaRepository extends MongoRepository<Entrega, UUID> {

}
