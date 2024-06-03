package com.test.api.jpa.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.api.dto.ConsumerRequest;
import com.test.api.jpa.constant.Role;
import com.test.api.jpa.entities.Consumer;
import com.test.api.jpa.repository.ConsumerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ConsumerService {
	
	private final ConsumerRepository consumerRepository;
	
//	회원 가입 정보 중복 확인
	private void validateDuplicateUser(Consumer user) {
		
		Consumer findUser = consumerRepository.findByPhone(user.getPhone());
		
		
		if(findUser != null) {
			
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}	
	}
	
//	가입 정보 저장 
	public Consumer saveUser(ConsumerRequest userFromDto) {
		Consumer user = Consumer.builder().user_id(userFromDto.getUser_id())
								  .name(userFromDto.getName())
								  .birth(userFromDto.getBirth())
								  .phone(userFromDto.getPhone())
								  .addr(userFromDto.getAddr())
								  .zipcode(userFromDto.getZipcode())
								  .activation("Y")
								  .role(Role.User)
								  .build();
		log.info("LocalDateTime.now() : {}", LocalDateTime.now());
		log.info("user : {}", user.toString());
								  
		validateDuplicateUser(user);
		return consumerRepository.save(user);
	}
	
}
