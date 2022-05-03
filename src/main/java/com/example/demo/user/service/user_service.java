package com.example.demo.user.service;

import com.example.demo.user.model.myUser;
import com.example.demo.user.passwordHashing.passwordHasher;
import com.example.demo.user.repository.user_repository;
import com.example.demo.user.response.response;
import com.example.demo.user.validation.user_validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;

@Service
public class user_service {

    @Autowired
    private user_repository userRepository;

    @Autowired
    private user_validation userValidation;

    @Autowired
    private passwordHasher passwordhasher;

    @Autowired
    private AuthenticationManagerBuilder ManagerBuilder;

    public ResponseEntity<response> register(myUser user){

        response validation = userValidation.validate(user);

        //validation
        try{
            if(!validation.getStatus()){
                return new ResponseEntity<>(new response(false, validation.getMessage()), HttpStatus.EXPECTATION_FAILED);
            }
        }catch(Exception e){
            return new ResponseEntity<>(new response(false, "Unable to register"), HttpStatus.BAD_REQUEST);
        }

        //exists
        try{
            myUser exists = userRepository.findByEmail(user.getEmail());
            if(exists != null){
                return new ResponseEntity<>(new response(false, "User already registered"), HttpStatus.IM_USED);
            }
        }catch(Exception e){
            return new ResponseEntity<>(new response(false, "Unable to register"), HttpStatus.BAD_REQUEST);
        }

        //store user
        try{
            user.setPassword(passwordhasher.hash(user.getPassword()));
            userRepository.save(user);
        }catch(Exception e){
            return new ResponseEntity<>(new response(false, "Unable to register"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new response(true, "Successful registration"), HttpStatus.CREATED);
    }
}
