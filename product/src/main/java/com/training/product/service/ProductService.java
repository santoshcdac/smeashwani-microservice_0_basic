package com.training.product.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.product.entity.ProductEntity;
import com.training.product.exception.ProductNotFoundException;
import com.training.product.model.ProductModel;
import com.training.product.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	ProductRepo repo;
	
	public ProductModel save(ProductModel data){
		ProductEntity proEntity = new ProductEntity();
		BeanUtils.copyProperties(data, proEntity);
		proEntity = repo.save(proEntity);
		BeanUtils.copyProperties(proEntity, data);
		return data;
	}
	
	public ArrayList<ProductEntity> findAll() {
		Iterable<ProductEntity> findAll = repo.findAll();
		ArrayList<ProductEntity> list = new ArrayList<ProductEntity>();
		findAll.forEach(item -> list.add(item));
		return list;
	}
	
	public ProductModel findById(Long id) {
		Optional<ProductEntity> findById = repo.findById(id);
		if(findById.isPresent()) {
			ProductModel productModel = new ProductModel();
			BeanUtils.copyProperties(findById.get(), productModel);
			return productModel;
		}
		else {
			throw new ProductNotFoundException("Product not Exists");
		}
		 
	}
}
