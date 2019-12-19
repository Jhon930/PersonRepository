package com.project.client.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.project.client.model.Account;

import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account,String>{
	
	Mono<Account> findById(String id);

}
