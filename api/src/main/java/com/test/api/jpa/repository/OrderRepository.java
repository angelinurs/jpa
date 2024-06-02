package com.test.api.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.api.jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
