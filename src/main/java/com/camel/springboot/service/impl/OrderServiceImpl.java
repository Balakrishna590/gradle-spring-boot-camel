package com.camel.springboot.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camel.springboot.jpa.entites.BookEntity;
import com.camel.springboot.jpa.entites.OrderEntity;
import com.camel.springboot.repositories.OrderRepository;
import com.camel.springboot.response.models.BookResponse;
import com.camel.springboot.response.models.OrderResponse;
import com.camel.springboot.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	private final Random amount = new Random();

	public OrderResponse generateOrder() {
		OrderResponse order = new OrderResponse();
		order.setAmount(amount.nextInt(10) + 1);
		OrderEntity orderEntity = orderRepository.findById(amount.nextInt(2) + 1).get();
		order.setBookResponse(convertEntityToResponse(orderEntity.getBookEntity()));
		return order;
	}

	private BookResponse convertEntityToResponse(BookEntity bookEntity) {
		BookResponse bookResponse = new BookResponse();
		bookResponse.setId(bookEntity.getId());
		bookResponse.setItem(bookEntity.getItem());
		bookResponse.setDescription(bookEntity.getDescription());
		return bookResponse;
	}
}
