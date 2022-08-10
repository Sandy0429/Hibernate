package com.sandhya.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
