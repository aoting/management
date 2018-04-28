package com.xat.model;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product {
	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@DBRef
	private List<Organisation> suppliers;
	
	@DBRef
	private List<Category> categories;
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Organisation> getSuppliers() {
		return suppliers;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
}
