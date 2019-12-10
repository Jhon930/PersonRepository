package com.project.client.services;

import com.project.client.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaService {
	
	public Flux<Persona> findAll();
	public Mono<Persona> findById(String id);
	public Mono<Persona> save(Persona persona);
	public Mono<Void> delete(Persona persona);
	public Mono<Persona> findByDni(String dni);
	public Mono<Persona> updatePersona(String id, Persona persona);
	

}
 