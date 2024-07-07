package com.estudo.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	
}
