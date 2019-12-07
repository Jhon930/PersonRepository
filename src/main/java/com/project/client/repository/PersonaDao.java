package com.project.client.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.project.client.model.Persona;

public interface PersonaDao extends ReactiveMongoRepository<Persona, String> {
	
	

}
