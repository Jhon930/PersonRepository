package com.project.client.util;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
	
	@Bean
	public Docket postsApi() {
	return new Docket(DocumentationType.SWAGGER_2).select()
			    .apis(RequestHandlerSelectors.basePackage("com.project.client.controller")).build();
	}

	/*private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/personas/listar.*"));
	}

    private ApiInfo usersApiInfo() {

        return new ApiInfoBuilder()
                .title("Service User")
                .version("1.0")
                .license("Apache License Version 2.0")
                .build();
    }*/


}
