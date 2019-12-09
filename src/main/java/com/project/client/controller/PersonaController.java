package com.project.client.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.client.model.Persona;
import com.project.client.services.PersonaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RefreshScope
@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService service;
	
	private static Logger log = LoggerFactory.getLogger(Persona.class);
	
	@GetMapping({"/listar", "/"})
	public Flux<Persona> listar(){
		
		Flux<Persona> personas = service.findAll();
		
		return personas;
		
	}
	
	@GetMapping("/{id}")
	public Mono<Persona> show(@PathVariable String id){
		
		Flux<Persona> personas = service.findAll();
		
		Mono<Persona> persona = personas.filter(p -> p.getId().equals(id))
				.next()
				.doOnNext(pers-> log.info(pers.getNombre()));
		
		return persona;
		
	}
	
	@PutMapping("/updatePersona/{id}")
    public Mono<Persona> updatePersona(@PathVariable(value = "id") String personaId,
                                                   @Valid @RequestBody Persona persona) {
		
		return service.updatePersona(personaId, persona);
    }
	
	@PostMapping("/")
    public Mono<Persona> createPersonas(@Valid @RequestBody Persona persona) {
        return service.save(persona);
    }
	
	@DeleteMapping("/deletePersona/{id}")
    public Mono<ResponseEntity<Void>> deletePersona(@PathVariable(value = "id") String personaId) {

        return service.findById(personaId)
            .flatMap(existingPersona ->
                    service.delete(existingPersona)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
            )
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
}
