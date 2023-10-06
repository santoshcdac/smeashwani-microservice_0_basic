package com.training.product.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.validation.constraints.Size;
import lombok.Data;

//@JsonFilter("productFilterDesc")
@Data
public class ProductModel {
	
	private Long Id;
	
	@Size(min = 3, message = "Should have at least 4 character")
	private String name;
	
	private String description;
}