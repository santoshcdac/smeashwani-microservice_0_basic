package com.training.product.repo;

import org.springframework.data.repository.CrudRepository;

import com.training.product.entity.Product;

public interface ProductRepo  extends CrudRepository<Product, Long>{

}
