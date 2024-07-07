package com.estudo.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
