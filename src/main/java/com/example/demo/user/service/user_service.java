package com.example.demo.user.service;

import com.example.demo.user.model.myUser;
import com.example.demo.user.passwordHashing.passwordHasher;
import com.example.demo.user.repository.show_user;
import com.example.demo.user.repository.user_repository;
import com.example.demo.user.request.user_patch;
import com.example.demo.user.response.register_response;
import com.example.demo.user.response.showUsers_response;
import com.example.demo.user.validation.user_validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class user_service {

    @Autowired
    private user_repository userRepository;

    @Autowired
    private user_validation userValidation;

    @Autowired
    private passwordHasher passwordhasher;

    public ResponseEntity<register_response> register(myUser user){

        register_response validation = userValidation.validate(user);

        //validation
        try{
            if(!validation.getStatus()){
                return new ResponseEntity<>(new register_response(false, validation.getMessage()), HttpStatus.EXPECTATION_FAILED);
            }
        }catch(Exception e){
            return new ResponseEntity<>(new register_response(false, "Unable to register"), HttpStatus.BAD_REQUEST);
        }

        //exists
        try{
            myUser exists = userRepository.findByEmail(user.getEmail());
            if(exists != null){
                return new ResponseEntity<>(new register_response(false, "User already registered"), HttpStatus.IM_USED);
            }
        }catch(Exception e){
            return new ResponseEntity<>(new register_response(false, "Unable to register"), HttpStatus.BAD_REQUEST);
        }

        //store user
        try{
            user.setPassword(passwordhasher.hash(user.getPassword()));
            userRepository.save(user);
        }catch(Exception e){
            return new ResponseEntity<>(new register_response(false, "Unable to register"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new register_response(true, "Successful registration"), HttpStatus.CREATED);
    }

    public ResponseEntity<showUsers_response> showUsers(Integer page, Integer size, String sortBy){

try {
    Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));

    Page<show_user> pagedResult = userRepository.showUsers(paging);

    Long itemsCount = pagedResult.getTotalElements();
    List<show_user> users = pagedResult.getContent();
    Integer totalPages = pagedResult.getTotalPages();
    Integer currentPage = page + 1;
    String message;

    if (pagedResult.hasContent()) {
        message = "Success";
        return new ResponseEntity<>(new showUsers_response(itemsCount, users, totalPages, currentPage, message), HttpStatus.OK);
    } else {
        message = "No content";
        return new ResponseEntity<>(new showUsers_response(itemsCount, users, totalPages, currentPage, message), HttpStatus.BAD_REQUEST);
    }
}
    catch(Exception e){
        return new ResponseEntity<>(new showUsers_response(0L, new ArrayList<>(), 0, 0, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

   public ResponseEntity<register_response> deleteUser(String email){
       try {
           Integer deletedRecords = userRepository.deleteByEmail(email);
       }catch(Exception e){
           System.out.println(e.getMessage());
           return new ResponseEntity<>(new register_response(false,"Unable to delete user"), HttpStatus.BAD_REQUEST);
       }
       SecurityContextHolder.clearContext();
       return new ResponseEntity<>(new register_response(true, "Successful deletion of user"), HttpStatus.OK);
   }

   public ResponseEntity<register_response> user_update(Principal principal, user_patch user){

        myUser existing_user;

        //find user
        try{
            existing_user = userRepository.findByEmail(principal.getName());
        }catch(Exception e){
            return new ResponseEntity<>(new register_response(false, "Unable to update user"), HttpStatus.BAD_REQUEST);
        }

     //update status
     if(user.getStatus() != null){
         try{
             existing_user.setStatus(user.getStatus());
             userRepository.save(existing_user);
         }catch(Exception e){
             System.out.println(e.getMessage());
             return new ResponseEntity<>(new register_response(false, "Unable to update status"), HttpStatus.BAD_REQUEST);
         }
     }

        return new ResponseEntity<>(new register_response(true, "Profile has been updated"), HttpStatus.ACCEPTED);
   }
}
