package com.training.product.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
		Link selfLink = WebMvcLinkBuilder.linkTo(ProductController.class).slash(product.getId()).withSelfRel();
		product.add(selfLink);
		return ResponseEntity.created(selfLink.toUri()).body(product);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productService.findById(id));
	}

	@GetMapping
	public ResponseEntity<ArrayList<ProductEntity>> getAll() {
		return ResponseEntity.ok().body(productService.findAll());
	}
	

}