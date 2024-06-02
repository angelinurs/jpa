package com.test.api.jpa.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.test.api.dto.OrderDTO;
import com.test.api.jpa.entities.Order;
import com.test.api.jpa.entities.Product;
import com.test.api.jpa.repository.OrderRepository;
import com.test.api.jpa.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	
	private Order getOrder(OrderDTO orderDTO) {
		
		Order order = Order.builder().u_code(orderDTO.getUser_id())
				.date(orderDTO.getDate())
				.u_addr(orderDTO.getAddr())
				.zip_code(orderDTO.getZip_code())
				.p_code(orderDTO.getP_code())
				.amount(orderDTO.getAmount())
				.status(orderDTO.getStatus())
				.build();
		
		return order;
	}
	
	private float addShippingPrice(String zip_code) {
		float total = 0.0f;
		
		return total;
	}
	
//	상품 재고 확인 
	public Map<String, Float> validateProductAmount( List<OrderDTO> orderDTOList) {
		
		Iterator<OrderDTO> iter =  orderDTOList.iterator();
		Map<String, Float> rtnval = new HashMap<>();
		int problemCount = 0;		
		
		OrderDTO orderDTO;
		Product product;
		
		while( iter.hasNext() ) {
			orderDTO = iter.next();
			log.error("orderDTO.toString(): {}",orderDTO.toString());
			product = productRepository.findByCode(orderDTO.getP_code());
						
			float amount = product.getAmount() - orderDTO.getAmount();
			
			if( amount < 0 ) {
				log.info("{} 의 재고가 부족합니다.", product.getName() );
				problemCount++;
			} else {
				product.setAmount(amount);
				orderRepository.save( getOrder(orderDTO) );
			}
			rtnval.put(product.getName(),amount);
		}
		rtnval.put("problemCount", (float)problemCount);
		
		return rtnval;
	}

//	상품 주문
	public Map<String, String> doOrderList( List<OrderDTO> orderDTOList) {
		
		Iterator<OrderDTO> iter =  orderDTOList.iterator();
		Map<String, String> rtnval = new HashMap<>();
		
		OrderDTO orderDTO;
		Product product;
		
		float total = 0.0f;
		
		while( iter.hasNext() ) {
			orderDTO = iter.next();
			product = productRepository.findByCode(orderDTO.getP_code());
			
			float amount = product.getAmount() - orderDTO.getAmount();
			product.setAmount(amount);
			productRepository.save( product );
			total += (product.getAmount() * product.getPrice());
		}
		rtnval.put("total", Float.toString(total));
		
		return rtnval;
	}
	
}
