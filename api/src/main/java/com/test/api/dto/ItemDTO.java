package com.test.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@Schema(title = "Order request DTO")
@ToString
public class ItemDTO {

	@Schema( description="상품코드", example = "d-t-12345")
	private String code;
	
	@Schema( description="상품 수량", example = "10")
	private float amount;

	@Builder
	public ItemDTO(String code, float price, float amount) {
		this.code = code;
		this.amount = amount;
	}

	
}
