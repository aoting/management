package com.xat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xat.db.repository.ProductRepository;
import com.xat.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Product create(Product product) {
		return productRepository.insert(product);
	}
	
	public List<Product> searchByName(String name) {
		return productRepository.searchByName(name);
	}
	
}
