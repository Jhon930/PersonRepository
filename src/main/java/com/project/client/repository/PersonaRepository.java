package com.project.client.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.project.client.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaRepository extends ReactiveMongoRepository<Persona, String> {
	


}
