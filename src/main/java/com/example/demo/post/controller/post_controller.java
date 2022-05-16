package com.example.demo.post.controller;

import com.example.demo.post.model.Post;
import com.example.demo.post.response.creation_response;
import com.example.demo.post.response.showPosts_response;
import com.example.demo.post.service.post_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showPosts")
    public ResponseEntity<showPosts_response> showPosts(@RequestParam(defaultValue = "1") Integer page,
                                                        @RequestParam(defaultValue = "5") Integer size,
                                                        @RequestParam(defaultValue = "created_at") String sortBy
    ) throws Exception {

        ResponseEntity<showPosts_response> response = postService.showPosts(page-1, size, sortBy);

        return response;
    }
}
