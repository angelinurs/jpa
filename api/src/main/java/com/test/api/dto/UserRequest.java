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
public class UserRequest {
	
	@NotBlank(message="가입자 ID 를 입력해주세요.")
	@Size(min=2, max=15, message = "가입자 ID를 15 글자 이하로 입력해주세요.")
	@Schema( description="가입자 ID", example = "naru")
	private String user_id;
	
	@NotBlank(message="가입자 이름을 입력해주세요.")
	@Size(min=2, max=15, message = "가입자 이름은 15 글자 이하로 입력해주세요.")
	@Schema( description="가입자 이름", example = "홍길동")
	private String name;
	
	private String password;
	
	private String phone;
	
	private String birth;
	
	private String addr;

	@Builder
	public UserRequest(
			@NotBlank(message = "가입자 ID 를 입력해주세요.") @Size(min = 2, max = 15, message = "가입자 ID를 15 글자 이하로 입력해주세요.") String user_id,
			@NotBlank(message = "가입자 이름을 입력해주세요.") @Size(min = 2, max = 15, message = "가입자 이름은 15 글자 이하로 입력해주세요.") String name,
			String password, String phone, String birth, String addr) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.birth = birth;
		this.addr = addr;
	}	
}
