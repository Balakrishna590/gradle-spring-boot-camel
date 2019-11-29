package com.camel.springboot.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Backend extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		// A first route generates some orders and queue them in DB
		from("timer:new-order?delay=1s&period={{example.generateOrderPeriod:2s}}").routeId("generate-order")
				.bean("orderService", "generateOrder").to("jpa:org.apache.camel.springboot.jpa.entites.OrderEntity")
				.log("Inserted new order ${body.id}");

		// A second route polls the DB for new orders and processes them
		from("jpa:org.apache.camel.springboot.jpa.entites.OrderEntity" + "?namedQuery=new-orders"
				+ "&delay={{example.processOrderPeriod:5s}}" + "&consumeDelete=false").routeId("process-order");
	}

}
