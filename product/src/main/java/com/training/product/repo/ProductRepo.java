package com.training.product.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.product.entity.ProductEntity;

@Repository
public interface ProductRepo  extends CrudRepository<ProductEntity, Long>{

}
