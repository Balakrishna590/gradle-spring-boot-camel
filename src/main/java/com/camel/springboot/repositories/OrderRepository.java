/**
 * 
 */
package com.camel.springboot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.camel.springboot.jpa.entites.OrderEntity;

/**
 * @author broutu
 *
 */
@Repository
@Transactional
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

	@Query("SELECT OrderEntity FROM OrderEntity OE")
	 public OrderEntity findOrder(Integer id);
}
