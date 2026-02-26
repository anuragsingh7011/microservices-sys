package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;
import com.order.entity.Order;
import com.order.feign.Product;
import com.order.feign.ProductClient;
import com.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductClient productClient;
	
	public String placeOrder(Order order) {
		Product product=productClient.getProduct(order.getProductId());
		 if (product != null && product.getQuantity() >= order.getQuantity()) {
			 orderRepository.save(order);
	            return "Order Placed Successfully";
	        }
		
		return "order not placed";
	}
}
