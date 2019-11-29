package com.camel.springboot.routes;

import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.camel.springboot.repositories.BookRepository;
import com.camel.springboot.repositories.OrderRepository;

public class RestApi extends SpringRouteBuilder {

	@Autowired
	private Environment env;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		restConfiguration().contextPath("/camel-rest-jpa").apiContextPath("/api-doc")
				.apiProperty("api.title", "Camel REST API").apiProperty("api.version", "1.0")
				.apiProperty("cors", "true").apiContextRouteId("doc-api").port(env.getProperty("server.port", "8080"))
				.bindingMode(RestBindingMode.json);

		rest("/books").description("Books REST service").get("/").description("The list of all the books").route()
				.routeId("books-api").bean(BookRepository.class, "findBooks").endRest().get("order/{id}")
				.description("Details of an order by id").route().routeId("order-api")
				.bean(OrderRepository.class, "findOrder(${header.id})");
	}

}
