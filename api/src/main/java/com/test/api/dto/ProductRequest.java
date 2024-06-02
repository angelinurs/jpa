package com.test.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@Schema(title = "Product registration request DTO")
@ToString
public class ProductRequest {
	
	@NotBlank(message="상품 코드를 입력해주세요.")
	@Size(min=2, max=15, message = "상품 코드를 15 글자 이하로 입력해주세요.")
	@Schema( description="상품 코드", example = "d-t-12345")
	private String code;
	
	@NotBlank(message="상품 종류를 입력해주세요.")
	@Size(min=2, max=15, message = "상품 종류를 15 글자 이하로 입력해주세요.")
	@Schema( description="상품 종류", example = "단가라 티셔츠")
	private String category;
	
	@NotBlank(message="상품 이름을 입력해주세요.")
	@Size(min=2, max=15, message = "상품 이름은 15 글자 이하로 입력해주세요.")
	@Schema( description="상품 이름", example = "예쁜 단가라 티셔츠")
	private String name;

	@NotBlank(message="상품 이미지 주소( amazon s3 주소 )를 입력해주세요.")
	@Schema( description="상품 이미지 주소", example = "s3://product-img/상품사진-1.jpeg")
	private String img_url;
	
	@NotBlank(message="상품 가격을 입력해주세요.")
	@Schema( description="상품 가격", example = "9900.0")
	private float price;
	
	@NotBlank(message="상품 수량을 입력해주세요.")
	@Schema( description="상품 수량", example = "10")
	private float amount;
	
	@NotBlank(message="상품 설명을 입력해주세요.")
	@Size(min=16, message = "상품 설명은 최소 16 글자 이상 입력해주세요.")
	@Schema( description="상품 설명", example = "너무 예쁜 단가라 티셔츠...blah blah")
	private String desc;

	@Builder
	public ProductRequest(
			@NotBlank(message = "상품 코드를 입력해주세요.") @Size(min = 2, max = 15, message = "상품 코드를 15 글자 이하로 입력해주세요.") String code,
			@NotBlank(message = "상품 종류를 입력해주세요.") @Size(min = 2, max = 15, message = "상품 종류를 15 글자 이하로 입력해주세요.") String category,
			@NotBlank(message = "상품 이름을 입력해주세요.") @Size(min = 2, max = 15, message = "상품 이름은 15 글자 이하로 입력해주세요.") String name,
			@NotBlank(message = "상품 이미지 주소( amazon s3 주소 )를 입력해주세요.") String img_url,
			@NotBlank(message = "상품 가격을 입력해주세요.") float price, @NotBlank(message = "상품 수량을 입력해주세요.") float amount,
			@NotBlank(message = "상품 설명을 입력해주세요.") @Size(min = 16, message = "상품 설명은 최소 16 글자 이상 입력해주세요.") String desc) {
		this.code = code;
		this.category = category;
		this.name = name;
		this.img_url = img_url;
		this.price = price;
		this.amount = amount;
		this.desc = desc;
	}	
}
