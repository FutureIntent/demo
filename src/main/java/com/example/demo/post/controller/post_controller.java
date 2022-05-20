package com.example.demo.post.controller;

import com.example.demo.post.model.Post;
import com.example.demo.post.request.showUser_request;
import com.example.demo.post.response.creation_response;
import com.example.demo.post.response.showPosts_response;
import com.example.demo.post.service.post_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.security.Principal;

@Controller
@RequestMapping("/post")
@Validated // class level
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

    @GetMapping("/userPosts")
    public ResponseEntity<showPosts_response> userPosts(
            Principal principal,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "created_at") String sortBy,
            @Valid @RequestBody(required = false) showUser_request email
    ) throws Exception {

        ResponseEntity<showPosts_response> response;

        if(email == null){
            response = postService.userPosts(page-1, size, sortBy, principal.getName());
        }else{
            response = postService.userPosts(page-1, size, sortBy, email.getEmail());
        }

        return response;
    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<creation_response> deleteUser(Principal principal, @PathVariable @Min(0) Long id) {

        ResponseEntity<creation_response> response = postService.deletePosts(principal, id);

        return response;
    }
}
