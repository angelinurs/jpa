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
@Schema(title = "Sign up request DTO")
@ToString
public class ConsumerRequest {
	
	@NotBlank(message="가입자 ID 를 입력해주세요.")
	@Size(min=2, max=15, message = "가입자 ID를 15 글자 이하로 입력해주세요.")
	@Schema( description="가입자 ID", example = "naru")
	private String user_id;
	
	@NotBlank(message="가입자 이름을 입력해주세요.")
	@Size(min=2, max=15, message = "가입자 이름은 15 글자 이하로 입력해주세요.")
	@Schema( description="가입자 이름", example = "홍길동")
	private String name;
	
	@NotBlank(message="가입자 비밀번호를 입력해주세요.")
	@Schema( description="password", example = "yong123!!")	
	private String password;
	
	@NotBlank(message="가입자 번호 입력해주세요.")
	@Schema( description="가입자 번호", example = "010-5432-6789")	
	private String phone;
	
	@NotBlank(message="가입자 생일을 입력해주세요.")
	@Schema( description="가입자 생일", example = "20040301")	
	private String birth;
	
	@NotBlank(message="가입자 주소를 입력해주세요.")
	@Schema( description="가입자 주소", example = "서울 성동구 성수이로16길 32 주3 1, 2층")	
	private String addr;
	
	@NotBlank(message="가입자 우편번호 입력해주세요.")
	@Schema( description="우편 번호", example = "04785")
	private String zipcode;

	@Builder
	public ConsumerRequest(
			@NotBlank(message = "가입자 ID 를 입력해주세요.") @Size(min = 2, max = 15, message = "가입자 ID를 15 글자 이하로 입력해주세요.") String user_id,
			@NotBlank(message = "가입자 이름을 입력해주세요.") @Size(min = 2, max = 15, message = "가입자 이름은 15 글자 이하로 입력해주세요.") String name,
			@NotBlank(message = "가입자 비밀번호를 입력해주세요.") String password,
			@NotBlank(message = "가입자 번호 입력해주세요.") String phone, @NotBlank(message = "가입자 생일을 입력해주세요.") String birth,
			@NotBlank(message = "가입자 주소를 입력해주세요.") String addr,
			@NotBlank(message = "가입자 우편번호 입력해주세요.") String zipcode) {
		this.user_id = user_id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.birth = birth;
		this.addr = addr;
		this.zipcode = zipcode;
	}	
}
