package com.test.api.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Builder
	public Member( Integer id, String name) {
		this.id = id;
		this.name = name;
	}

}
