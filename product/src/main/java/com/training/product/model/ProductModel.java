package com.training.product.model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductModel extends RepresentationModel{
	private Long Id;
	
	@Size(min = 3, message = "Should have at least 4 character")
	private String name;
	
	private String description;
}
