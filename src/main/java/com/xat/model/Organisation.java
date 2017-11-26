package com.xat.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="organisations")
public class Organisation {
	protected String id;
	protected String name;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
