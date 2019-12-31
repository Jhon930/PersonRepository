package com.project.client.services;

import com.project.client.model.Account;
import com.project.client.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
	
	public Flux<Person> findAll();
	public Mono<Person> save(Person person);
	public Mono<Void> delete(Person person);
	//public Mono<Persona> findByDni(String dni);
	public Mono<Person> findById(String id);
	public Mono<Person> updatePersona(String id, Person person);

}
 