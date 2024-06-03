package com.test.api.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.api.jpa.entities.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
	
	Consumer findByName(String name);
	Consumer findByPhone(String Phone);

}
