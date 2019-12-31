package com.project.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.project.client.controller.PersonController;
import com.project.client.model.Person;
import com.project.client.services.PersonService;

@Configuration
public class RouterConfig {
	
	@Autowired
	private PersonService service;
	
	@Bean
	public RouterFunction<ServerResponse> rutas(){
		
		return route(GET("/api/person"), request -> {
			return ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(service.findAll(), Person.class);
		});
	}

}
