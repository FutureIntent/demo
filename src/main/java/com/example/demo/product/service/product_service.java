package com.example.demo.product.service;

import com.example.demo.product.model.Product_food;
import com.example.demo.product.repository.food_repository;
import com.example.demo.product.response.creation_response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class product_service {

    @Autowired
    food_repository foodRepository;

    public ResponseEntity<creation_response> createFoodProduct(Product_food food){


        try{
            foodRepository.save(food);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new creation_response(false, "Unable to create food product"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new creation_response(true, "Food product has been created"), HttpStatus.CREATED);
    }
}
