/**
 * 
 */
package com.camel.springboot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.camel.springboot.jpa.entites.OrderEntity;

/**
 * @author broutu
 *
 */

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

	@Query("SELECT OrderEntity FROM OrderEntity OE")
	 public OrderEntity findOrder(Integer id);
}
