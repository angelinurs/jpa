package com.test.api.jpa.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.api.dto.UserRequest;
import com.test.api.jpa.constant.Role;
import com.test.api.jpa.entities.User;
import com.test.api.jpa.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UsersService {
	
	private final UserRepository userRepository;
	
//	회원 가입 정보 중복 확인
	private void validateDuplicateUser(User user) {
		
		User findUser = userRepository.findByPhone(user.getPhone());
		
		
		if(findUser != null) {
			
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}	
	}
	
//	가입 정보 저장 
	public User saveUser(UserRequest userFromDto) {
		User user = User.builder().user_id(userFromDto.getUser_id())
								  .name(userFromDto.getName())
								  .birth(userFromDto.getBirth())
								  .phone(userFromDto.getAddr())
								  .addr(userFromDto.getPhone())
								  .creation_date(LocalDateTime.now())
								  .activation("Y")
								  .role(Role.User)
								  .build();
		log.info("LocalDateTime.now() : {}", LocalDateTime.now());
		log.info("user : {}", user.toString());
								  
		validateDuplicateUser(user);
		return userRepository.save(user);
	}
	
}
