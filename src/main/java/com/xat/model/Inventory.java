package com.xat.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public class Inventory {
	@Id
	protected String id;
	@NotBlank
	protected Product product;
	@NotEmpty
	protected int amount;
	
	protected double supplierPrice;
	protected double retailPrice;
}
