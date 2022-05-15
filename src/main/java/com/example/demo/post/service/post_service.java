package com.example.demo.post.service;

import com.example.demo.post.model.Post;
import com.example.demo.post.repository.post_repository;
import com.example.demo.post.response.creation_response;
import com.example.demo.user.model.myUser;
import com.example.demo.user.repository.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class post_service {

    @Autowired
    user_repository userRepository;

    @Autowired
    post_repository postRepository;

    public ResponseEntity<creation_response> create_post(Post post, Principal principal){
        try{
            myUser user = userRepository.findByEmail(principal.getName());
            post.setUser(user);
            postRepository.save(post);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new creation_response(false, "Unable to create post"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new creation_response(true, "Post has been created"), HttpStatus.OK);
    }
}
