package com.example.demo.user.service;

import com.example.demo.user.model.User;
import com.example.demo.user.repository.user_repository;
import com.example.demo.user.response.response;
import com.example.demo.user.validation.user_validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class user_service {

    @Autowired
    private user_repository userRepository;

    @Autowired
    private user_validation userValidation ;

    public ResponseEntity<response> register(User user){

        response validation = userValidation.validate(user);

        try{
            if(!validation.getStatus()){
                return new ResponseEntity<>(new response(false, validation.getMessage()), HttpStatus.EXPECTATION_FAILED);
            }
        }catch(Exception e){
            return new ResponseEntity<>(new response(false, "Unable to register"), HttpStatus.BAD_REQUEST);
        }

        try{
            User exists = userRepository.findByEmail(user.getEmail());
            if(exists != null){
                return new ResponseEntity<>(new response(false, "User already registered"), HttpStatus.IM_USED);
            }
        }catch(Exception e){
            return new ResponseEntity<>(new response(false, "Unable to register"), HttpStatus.BAD_REQUEST);
        }

        try{
            userRepository.save(user);
        }catch(Exception e){
            return new ResponseEntity<>(new response(false, "Unable to register"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new response(true, "Successful registration"), HttpStatus.CREATED);
    }
}
