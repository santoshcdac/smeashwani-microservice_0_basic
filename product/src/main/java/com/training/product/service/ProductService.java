package com.training.product.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.product.entity.ProductEntity;
import com.training.product.model.ProductModel;
import com.training.product.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	ProductRepo repo;
	
	public ProductEntity save(ProductModel d){
		ProductEntity proEntity = new ProductEntity();
		BeanUtils.copyProperties(d, proEntity);
		return repo.save(proEntity);
	}
	
	public Iterable<ProductEntity>  findAll() {
		return repo.findAll();
	}
	
	public Optional<ProductEntity> findById(Long id) {
		 return  repo.findById(id);
	}
}
