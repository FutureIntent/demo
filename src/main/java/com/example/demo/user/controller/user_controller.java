package com.example.demo.user.controller;

import com.example.demo.user.model.myUser;
import com.example.demo.user.response.response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class user_controller {

    @Autowired
    com.example.demo.user.service.user_service user_service;

    @PostMapping("/register")
    public ResponseEntity<response> registration(@Valid @RequestBody myUser user){
        ResponseEntity<response> response = user_service.register(user);
        return response;
    }

    @GetMapping("/test")
    public ResponseEntity<response> test(){
        System.out.println("test");
        return new ResponseEntity<>(new response(true,"test"), HttpStatus.ACCEPTED);
    }
}
