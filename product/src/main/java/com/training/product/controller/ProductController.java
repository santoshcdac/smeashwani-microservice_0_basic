package com.training.product.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.product.entity.ProductEntity;
import com.training.product.model.ProductModel;
import com.training.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public ProductEntity save(@RequestBody ProductModel data) {
		return productService.save(data);
	}
	
	@GetMapping("/{id}")
	public ProductEntity findById(@PathVariable Long id) {
		Optional<ProductEntity> findById = productService.findById(id);
		return findById.isPresent()? findById.get(): null;
	}
	
	@GetMapping
	public ArrayList<ProductEntity> getAll() {
		ArrayList<ProductEntity> list = new ArrayList();
		Iterable<ProductEntity> findAll = productService.findAll();
		findAll.forEach(item -> list.add(item));
		return list;
	}
	
	
}
