package com.test.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.dto.ProductRequest;
import com.test.api.jpa.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;

	@PostMapping( "/registry" )
	@Operation( summary = "Product Registration API summary", description = "code 0: 정상\ncode 1: 상품 이름 중복\ncode 1: 상품 코드 중복")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Success",
					content = {@Content(schema = @Schema(implementation = ProductRequest.class))}),
			@ApiResponse(responseCode = "404", description = "Not Found"),
	})
	
	public Map<String, Integer> registry(@RequestBody @Valid ProductRequest productRequest ) {
		
		Map<String, Integer> rtnval = productService.validateDuplicateProduct(productRequest);
		  
		
		if( rtnval.get("code") == 0 ) {
			productService.saveProduct(productRequest);
		}
		
		return rtnval;
	}
}
