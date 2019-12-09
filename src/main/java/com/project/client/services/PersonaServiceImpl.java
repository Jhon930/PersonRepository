package com.project.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.client.model.Persona;
import com.project.client.repository.PersonaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository repository;

	@Override
	public Flux<Persona> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<Persona> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Mono<Persona> save(Persona persona) {
		// TODO Auto-generated method stub
		return repository.save(persona);
	}

	@Override
	public Mono<Void> delete(Persona persona) {
		// TODO Auto-generated method stub
		return repository.delete(persona);
	}

	@Override
	public Flux<Persona> findAllByName() {
		// TODO Auto-generated method stub
		return repository.findAll().map(persona -> {
		   persona.setNombre(persona.getNombre().toUpperCase());
		   return persona;
		});
	}

	@Override
	public Mono<Persona> findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Persona> updatePersona(String id, Persona persona) {
		return findById(id)
			.map(p -> persona)
			.flatMap(repository::save)
			.switchIfEmpty(Mono.error(new Exception()));
	}
	
	

}
