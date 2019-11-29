package com.camel.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Configuration
public class CamelSpringBootApplication 	extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CamelSpringBootApplication.class, args);
	}

}
