package com.training.product.model;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductModel{
	private Long Id;
	
	@Size(min = 3, message = "Should have at least 4 character")
	private String name;
	
	private String description;
}
