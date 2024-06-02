package com.test.api.jpa.entities;

import java.time.LocalDateTime;

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
@Table(name = "order")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "U_CODE", nullable = false)
	private String u_code;
	
	@Column(name = "P_CODE", nullable = false)
	private String p_code;
	
	@Column(name = "DATE", nullable = false)
	private LocalDateTime date;
	
	@Column(name = "U_ADDR", nullable = false)
	private String u_addr;
	
	@Column(name = "ZIP_CODE", nullable = false)
	private String zip_code;
	
	@Column(name = "AMOUNT", nullable = false)
	private int amount;
	
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@Column(name = "ARRIVED")
	private String arrived;

	@Builder
	public Order(Long id, String u_code, String p_code, LocalDateTime date, String u_addr, String zip_code, int amount,
			String status, String arrived) {
		this.id = id;
		this.u_code = u_code;
		this.p_code = p_code;
		this.date = date;
		this.u_addr = u_addr;
		this.zip_code = zip_code;
		this.amount = amount;
		this.status = status;
		this.arrived = arrived;
	}

}
