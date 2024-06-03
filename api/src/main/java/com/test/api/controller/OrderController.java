package com.test.api.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.dto.OrderDTO;
import com.test.api.dto.ProductRequest;
import com.test.api.jpa.service.OrderService;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService orderService;

//	@PostMapping( "/request" )
//	@Operation( summary = "Order API summary", description = "code 0: 정상\ncode 1: 상품 이름 중복\ncode 1: 상품 코드 중복")
//	@ApiResponses(value= {
//			@ApiResponse(
//		            responseCode = "200", description = "Success",
//		            content = @Content(
//		                mediaType = MediaType.APPLICATION_JSON_VALUE,
//		                array = @ArraySchema(
//		                    schema = @Schema(
//		                        implementation = OrderDTO.class
//		                    )
//		                )
//		            )
//		        ),
//			@ApiResponse(responseCode = "404", description = "Not Found"),
//	})
//	public List<OrderDTO> registry(@RequestBody @Valid List<OrderDTO> orderDTOList ) {
//		
//		return orderDTOList;
//	}
	
	@PostMapping( "/request" )
	@Operation( summary = "Order API summary", description = "code 0: 정상\ncode 1: 상품 이름 중복\ncode 1: 상품 코드 중복")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Success",
					content = {@Content(schema = @Schema(implementation = OrderDTO.class))}),
			@ApiResponse(responseCode = "404", description = "Not Found"),
	})
	public OrderDTO registry(@RequestBody @Valid OrderDTO orderDTO ) {
		
		return orderDTO;
	}
}
