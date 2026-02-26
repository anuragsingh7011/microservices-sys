package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
		
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return	productRepository.save(product);
	}
	
	public Product getProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}
}
