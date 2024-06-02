package com.test.api.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.api.jpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByName(String name);
	Product findByCode(String code);

}
