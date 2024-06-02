package com.test.api.jpa.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.test.api.jpa.constant.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "user")
//@DynamicUpdate
//@DynamicInsert
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;	
	
	@Column(name = "USER_ID", nullable = false)
	private String user_id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "PHONE",unique = true , nullable = false)
	private String phone;
	
	@Column(name = "CREATION_DATE", nullable = false)
	private LocalDateTime creation_date;
	
	@Column(name = "BIRIH", nullable = false)
	private String birth;
	
	@Column(name = "ADDR", nullable = false)
	private String addr;
	
	@Column(name = "ACTIVATION", nullable = false)
	private String activation;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	@Builder
	public User(Long id, String user_id, String name, String phone, LocalDateTime creation_date, String birth,
			String addr, String activation, Role role) {
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.phone = phone;
		this.creation_date = creation_date;
		this.birth = birth;
		this.addr = addr;
		this.activation = activation;
		this.role = role;
	}

	
}
