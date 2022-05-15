package com.example.demo.post.controller;

import com.example.demo.post.model.Post;
import com.example.demo.post.response.creation_response;
import com.example.demo.post.service.post_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/post")
public class post_controller {

    @Autowired
    post_service postService;

    @PostMapping("/create")
    public ResponseEntity<creation_response> new_post(@Valid @RequestBody Post post, Principal principal){

        ResponseEntity<creation_response> response = postService.create_post(post, principal);

        return response;
    }
}
