package com.example.demo.product.controller;

import com.example.demo.product.model.Product_food;
import com.example.demo.product.response.creation_response;
import com.example.demo.product.service.product_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class product {

    @Autowired
    product_service productService;

    @PostMapping("/product/createFoodProduct")
    public ResponseEntity<creation_response> createFoodProduct(@Valid @RequestBody Product_food food){

       ResponseEntity<creation_response> response = productService.createFoodProduct(food);

       return response;

    }

}
