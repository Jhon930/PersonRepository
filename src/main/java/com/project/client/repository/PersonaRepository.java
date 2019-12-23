package com.project.client.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.project.client.model.Account;
import com.project.client.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaRepository extends ReactiveMongoRepository<Persona, String> {

	 @Query(value="{'dni': ?0}")
	 Mono<Persona> findByDni(String dni);
	 
	 @Query(value="{'numberAccount': ?0}")
	 Flux<Account> findPersonByNumberAccount(String number);
	 
}
