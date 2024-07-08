package com.estudo.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	
	
}
