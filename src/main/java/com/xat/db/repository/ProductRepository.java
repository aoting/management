package com.xat.db.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.xat.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	public List<Product> findAll();
	public Product findById(final String id);
	
	@Query("{'name':{ $regex: ?0, $options: 'i' }}")
	public List<Product> searchByName(String name);
}
