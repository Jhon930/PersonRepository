package com.project.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PersonaMicroserviceApiApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PersonaMicroserviceApiApplication.class, args);
	}
	
	public WebClient registrarWebClient() {
		return WebClient.create("http://localhost:8070/api/account");
	}
}
