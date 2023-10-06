package com.training.product.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductModel {
	
	@JsonView(RestrictedView.ProductModelResView.class)
	private Long id;
	
	@JsonView(RestrictedView.ProductModelResView.class)
	@Size(min = 3, message = "Should have at least 4 character")
	private String name;
	
	private String description;
}