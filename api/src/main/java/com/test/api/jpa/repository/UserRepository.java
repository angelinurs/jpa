package com.test.api.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.api.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByName(String name);
	User findByPhone(String Phone);

}
