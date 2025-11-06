package com.pathfinder.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI CommonOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("Swagger common API")
				.description("공통 모듈 스웨거")
				.version("1.0")
				.contact(new Contact()
					.name("PathFinder"))
				.license(new License().name("Apache 2.0")));
	}
}
