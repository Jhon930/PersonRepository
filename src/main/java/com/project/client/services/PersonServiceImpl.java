package com.project.client.services;

import static org.springframework.http.MediaType.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.client.model.Account;
import com.project.client.model.Person;
import com.project.client.repository.AccountRepository;
import com.project.client.repository.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private AccountRepository cRepository;

	@Override
	public Flux<Person> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<Person> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Mono<Person> save(Person person) {
		// TODO Auto-generated method stub
		return repository.save(person);
	}

	@Override
	public Mono<Void> delete(Person person) {
		// TODO Auto-generated method stub
		return repository.delete(person);
	}


	@Override
	public Mono<Person> updatePersona(String id, Person person) {
		return findById(id)
			.map(p -> person)
			.flatMap(repository::save)
			.switchIfEmpty(Mono.error(new Exception()));
	}



	

}
