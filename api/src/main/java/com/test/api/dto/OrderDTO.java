package com.test.api.dto;

import java.time.LocalDateTime;

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
public class OrderDTO {

	@Schema( description="주문자 ID", example = "naru")
	private String user_id;

	@Schema( description="주문 날짜", example = "2024-05-01T16:26:39.098")
	private LocalDateTime date;

	@Schema( description="배송 주소", example = "서울특별시 강남구 신사동 논현로175길")
	private String addr;

	@Schema( description="우편번호", example = "06030")
	private String zip_code;

	@Schema( description="상품코드", example = "d-t-12345")
	private String p_code;

	@Schema( description="상품 주문량", example = "5")
	private int amount;

	@Schema( description="배송상태", example = "배송준비/배송중/배송완료")
	private String status;

	@Builder
	public OrderDTO(String user_id, LocalDateTime date, String addr, String zip_code, String p_code, int amount,
			String status) {
		this.user_id = user_id;
		this.date = date;
		this.addr = addr;
		this.zip_code = zip_code;
		this.p_code = p_code;
		this.amount = amount;
		this.status = status;
	}
	
}
