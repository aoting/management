package com.xat.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="organisations")
public class Organisation {
	protected String id;
	protected String name;
	protected List<Inventory> inventories;
	
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
