package com.project.client.services;

import com.project.client.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaService {
	
	public Flux<Persona> findAll();
	public Flux<Persona> findAllByName();
	public Mono<Persona> findById(String id);
	public Mono<Persona> save(Persona persona);
	public Mono<Void> delete(Persona persona);
	

}
 