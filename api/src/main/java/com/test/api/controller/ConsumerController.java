package com.test.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.dto.ConsumerRequest;
import com.test.api.jpa.service.ConsumerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class ConsumerController {
	
	private final ConsumerService consumerService;

	@PostMapping( "/signup" )
	@Operation( summary = "Sign Up API summary", description = "Sign up")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Success",
					content = {@Content(schema = @Schema(implementation = ConsumerRequest.class))}),
			@ApiResponse(responseCode = "404", description = "Not Found"),
	})
	public String signUp(@RequestBody @Valid ConsumerRequest consumerRequest ) {
		
		consumerService.saveUser(consumerRequest);
		
		return consumerRequest.toString();
	}
}
