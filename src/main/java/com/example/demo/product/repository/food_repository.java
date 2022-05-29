package com.example.demo.product.repository;

import com.example.demo.product.model.Product_food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface food_repository extends CrudRepository<Product_food, Long> {

}
