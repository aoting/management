package com.xat.model;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="categories")
public class Category {
	@Id
	private String id;
	
	@NotBlank
	private String name;
}
