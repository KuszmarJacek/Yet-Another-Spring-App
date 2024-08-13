package com.kj.yetanotherspringapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI openapiRestDocumentation() {
		return new OpenAPI()
			.info(new Info()
				.title("Yet Another Spring App REST API")
				.description("This doc lists all REST API endpoints for this app")
				.version("1.0"));
	}
}
