package com.training.product.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.Size;
import lombok.Data;


@JsonIgnoreProperties(value={"description"})
//@JsonPropertyOrder(alphabetic = false)
@JsonPropertyOrder(value = {"productId","name","description"})
@Data
public class ProductModel {
	
	@JsonProperty("productId")
	private Long Id;
	
	@Size(min = 3, message = "Should have at least 4 character")
	private String name;
	
	//@JsonIgnore
	private String description;
}
