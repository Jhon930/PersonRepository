package com.project.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.client.model.Persona;
import com.project.client.repository.PersonaDao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaDao dao;

	@Override
	public Flux<Persona> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Mono<Persona> findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Mono<Persona> save(Persona persona) {
		// TODO Auto-generated method stub
		return dao.save(persona);
	}

	@Override
	public Mono<Void> delete(Persona persona) {
		// TODO Auto-generated method stub
		return dao.delete(persona);
	}

	@Override
	public Flux<Persona> findAllByName() {
		// TODO Auto-generated method stub
		return dao.findAll().map(persona -> {
		   persona.setNombre(persona.getNombre().toUpperCase());
		   return persona;
		});
	}

}
