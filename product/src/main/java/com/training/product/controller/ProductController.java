package com.training.product.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.product.entity.ProductEntity;
import com.training.product.model.ProductModel;
import com.training.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductModel> save(@Valid @RequestBody ProductModel data) {
		ProductModel product = productService.save(data);
		return ResponseEntity.created(null).body(product);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productService.findById(id));
	}

	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ArrayList<ProductEntity>> getAll() {
		return ResponseEntity.ok().body(productService.findAll());
	}
}