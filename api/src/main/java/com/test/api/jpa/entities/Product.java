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
@Table(name = "product")
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CODE", nullable = false)
	private String code;
	
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "IMG_URL", nullable = false)
	private String img_url;
	
	@Column(name = "PRICE", nullable = false)
	private float price;
	
	@Column(name = "AMOUNT", nullable = false)
	private float amount;
	
	@Column(name = "DESC", nullable = false)
	private String desc;
	
	@Builder
	public Product(Long id, String code, String category, String name, String img_url, float price,
			float amount, String desc) {
		this.id = id;
		this.code = code;
		this.category = category;
		this.name = name;
		this.img_url = img_url;
		this.price = price;
		this.amount = amount;
		this.desc = desc;
	}

}
