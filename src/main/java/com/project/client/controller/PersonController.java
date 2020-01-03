package com.project.client.controller;


import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.client.model.Account;
import com.project.client.model.Person;
import com.project.client.repository.PersonRepository;
import com.project.client.services.PersonService;
import com.project.client.utils.PersonaMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService service;
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
    private WebClient.Builder webClientBuilder;
	
	private static Logger log = LoggerFactory.getLogger(Person.class);
	
	@GetMapping
	public Mono<ResponseEntity<Flux<Person>>> findAllPerson(){
		
		return Mono.just(ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(service.findAll())
				);
		
	}
	
	@GetMapping("/account/{account}")
	public Flux<Account> findByAccount(@PathVariable("account") String numAccount) {
		LOGGER.info("findByAccount: numAccount={}", numAccount);
		return repository.findPersonByNumberAccount(numAccount);
	}
	
	@GetMapping("/person/{id}")
	public Mono<ResponseEntity<Person>> showPerson(@PathVariable String id){
		return service.findById(id).map(p -> ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{dni}")
	public Mono<Person> findByDni(@PathVariable("dni") String dni){
		
		Flux<Person> persons = service.findAll();
		
		Mono<Person> person = persons.filter(p -> p.getDni().equals(dni))
				.next()
				.doOnNext(pers-> log.info(pers.getName()));
		
		return person;
		
	}
	
	@PutMapping("/updatePersona/{id}")
    public Mono <ResponseEntity<Person>> updatePerson(@Valid @RequestBody Person person, @PathVariable(value = "id") String id){
		
		return service.findById(id).flatMap(p-> {
			 p.setName(person.getName());
			 p.setLastName(person.getLastName());
			 p.setDni(person.getDni());
			 p.setAddress(person.getAddress());
			 p.setPhoneNumber(person.getPhoneNumber());
			 p.setMobilePhoneNumber(person.getMobilePhoneNumber());
			 return service.save(person);
		}).map(p-> ResponseEntity.created(URI.create("/api/person/".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(p))
		.defaultIfEmpty(ResponseEntity.notFound().build());
    }
	
	@PostMapping("/")
    public Mono<ResponseEntity<Map<String, Object>>> createPerson(@Valid @RequestBody Mono<Person> monoPerson) {
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		return monoPerson.flatMap(person -> {
			return service.save(person).map(p-> {
				response.put("person", p);
				response.put("mensaje", "Created");
				return ResponseEntity
						.created(URI.create("/api/person/".concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(response);
			});
		}).onErrorResume(t->{
			return Mono.just(t).cast(WebExchangeBindException.class)
					.flatMap(e-> Mono.just(e.getFieldErrors()))
					.flatMapMany(Flux::fromIterable)
					.map(fieldError -> "Field " + fieldError.getField() + " " + fieldError.getDefaultMessage())
					.collectList()
					.flatMap(list -> {
						response.put("errors",list);
						response.put("status",HttpStatus.BAD_REQUEST.value());
						return Mono.just(ResponseEntity.badRequest().body(response));
					});
		});
		
        
    }
	
	@DeleteMapping("/deletePersona/{id}")
    public Mono<ResponseEntity<Void>> deletePerson(@PathVariable(value = "id") String personaId) {

        return service.findById(personaId)
            .flatMap(existingPersona ->
                    service.delete(existingPersona)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
            )
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	@GetMapping("/{dni}/accounts")
	public Mono<Person> findAccountsByDniPerson(@PathVariable("dni") String dni) {
		
		LOGGER.info("findAccountsByDniPerson: dni={}", dni);
		Flux <Account> accounts = webClientBuilder.build().get().uri("http://localhost:8070/person/{person}", dni).retrieve().bodyToFlux(Account.class);		
		return accounts
				.collectList()
				.map(a -> new Person(a))
				.mergeWith(repository.findByDni(dni))
				.collectList()
				.map(PersonaMapper::map);
	}
	

	
	
}
