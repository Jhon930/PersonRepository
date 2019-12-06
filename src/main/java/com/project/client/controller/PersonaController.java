package com.project.client.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.client.model.Persona;

@RefreshScope
@RestController
public class PersonaController {
	
	/*@Value("${message: Default Hello}")
	private String message;
	
	@GetMapping("/message")
	public String message() {
		return message;
	}*/
	
	@Autowired
	private Environment env;
	
	private static Logger log = LoggerFactory.getLogger(Persona.class);
	
	@Value("${configuracion.texto}")
	private String texto;

	
	@GetMapping("/obtener-config")
	public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String puerto){
		
		log.info(texto);
		Map<String, String> json = new HashMap<>();
		json.put("texto", texto);
		json.put("puerto", puerto);
		
		if(env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")) {
			json.put("autor.nombre", env.getProperty("configuracion.autor.nombre"));
			json.put("autor.email", env.getProperty("configuracion.autor.email"));
		}
		
		return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK);
		
	}

}
