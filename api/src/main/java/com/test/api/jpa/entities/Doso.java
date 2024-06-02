package com.test.api.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "doso")
public class Doso {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;	
	
	@Column(name = "CITY", nullable = false)
	private String city;
	
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	
	@Column(name = "START_ZIP", nullable = false)
	private String start_zip;
	
	@Column(name = "END_ZIP", nullable = false)
	private String end_zip;

	@Builder
	public Doso(Long id, String city, String category, String start_zip, String end_zip) {
		super();
		this.id = id;
		this.city = city;
		this.category = category;
		this.start_zip = start_zip;
		this.end_zip = end_zip;
	}
	
}
