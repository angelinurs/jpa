package com.test.api.jpa.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Table(name = "order")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "U_CODE", nullable = false)
	private String u_code;
	
	@Column(name = "PHONE", nullable = false)
	private String phone;
	
	@Column(name = "U_ADDR", nullable = false)
	private String u_addr;
	
	@Column(name = "ZIP_CODE", nullable = false)
	private String zip_code;
	
	@Column(name = "P_CODE", nullable = false)
	private String p_code;

    @OneToMany
    @JoinTable(name = "ORDER_PRODUCTS",
            joinColumns = @JoinColumn(name = "P_CODE"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> products = new ArrayList<>();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE", nullable = false)
	private LocalDateTime date;
	
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
		this.status = status;
		this.arrived = arrived;
	}

}
