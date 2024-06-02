package com.test.api.jpa.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.api.dto.ProductRequest;
import com.test.api.jpa.entities.Product;
import com.test.api.jpa.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
	private Product getProduct(ProductRequest productRequest) {
		
		Product product = Product.builder().code(productRequest.getCode())
				.category(productRequest.getCategory())
				.name(productRequest.getName())
				.img_url(productRequest.getImg_url())
				.price(productRequest.getPrice())
				.amount(productRequest.getAmount())
				.desc(productRequest.getDesc())
				.build();
		
		return product;
	}
	
	public Product saveProduct(ProductRequest productRequest) {
		
		Product product = getProduct(productRequest);			                           
		
		log.info("product : {}", product.toString());
								  
//		validateDuplicateProduct(product);
		return productRepository.save(product);
	}
	
	public Map<String, Integer> validateDuplicateProduct(ProductRequest productRequest) {
		
		Product product = getProduct(productRequest);			                           
		
		Map<String, Integer> rtnval = new HashMap<>();
		rtnval.put("code", 0);
		
		Product findName = productRepository.findByName(product.getName());
		Product findCode = productRepository.findByName(product.getCode());
				                         
		
		if(findName != null) {
			
//			throw new IllegalStateException("동일한 이름의 상품이 존재합니다.");
			rtnval.put("code", 1);
		}
		
		if(findCode != null) {
			
//			throw new IllegalStateException("동일한 상품코드가 존재합니다.");
			rtnval.put("code", 2);
		}
		
		return rtnval;
	}
	
}
