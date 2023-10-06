package com.training.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.training.product.model.ProductModel;
import com.training.product.model.RestrictedView;
import com.training.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@Operation(summary = "Create new Product")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Created Product") })
	@PostMapping
	public ResponseEntity<ProductModel> save(@Valid @RequestBody ProductModel data) {
		ProductModel product = productService.save(data);
		return ResponseEntity.created(null).body(product);
	}

	@Operation(summary = "Find Product")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully got Product"),
			@ApiResponse(responseCode = "404", description = "Product is not exists") })
	@GetMapping("/{id}")
	public ResponseEntity<ProductModel> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productService.findById(id));
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<ProductModel>> getAll() {
		return ResponseEntity.ok().body(productService.findAll());
	}

	@JsonView(RestrictedView.ProductModelResView.class)
	@GetMapping("/allProduct")
	public ResponseEntity<List<ProductModel>> getAllProduct() {
		return ResponseEntity.ok().body(productService.findAll());
	}
}