package com.example.demo.user.controller;

import com.example.demo.mail.EmailServiceImpl;
import com.example.demo.post.model.Post;
import com.example.demo.post.repository.post_repository;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.user_repository;
import com.example.demo.user.request.message;
import com.example.demo.user.request.user_patch;
import com.example.demo.user.response.register_response;
import com.example.demo.user.response.showUsers_response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class user_controller {

    @Autowired
    com.example.demo.user.service.user_service user_service;

    @Autowired
    user_repository userRepository;

    @Autowired
    post_repository postRepository;

    @Autowired
    EmailServiceImpl emailServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<register_response> registration(@Valid @RequestBody User user){
        ResponseEntity<register_response> response = user_service.register(user);
        return response;
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<register_response> deleteUser(Principal principal){

        String email = principal.getName();
        ResponseEntity<register_response> response = user_service.deleteUser(email);

        return response;
    }

    @GetMapping("/showUsers")
    public ResponseEntity<showUsers_response> showUsers(@RequestParam(defaultValue = "1") Integer page,
                                                        @RequestParam(defaultValue = "5") Integer size,
                                                        @RequestParam(defaultValue = "email") String sortBy
                                                  ) throws Exception {

        ResponseEntity<showUsers_response> response = user_service.showUsers(page-1, size, sortBy);

        return response;
    }

    @PatchMapping("/update")
    public ResponseEntity<register_response> updateUser(Principal principal, @Valid @RequestBody user_patch user){

        ResponseEntity<register_response> response = user_service.user_update(principal, user);

        return response;
    }

    @PostMapping("/message")
    public ResponseEntity<register_response> sendMessage(@RequestBody message message){

        String to = message.getTo();
        String subject = message.getSubject();
        String text = message.getText();

       try{
           emailServiceImpl.sendSimpleMessage(to,subject,text);
       }catch(Exception e){
           return new ResponseEntity<>(new register_response(false, e.getMessage()), HttpStatus.BAD_GATEWAY);
       }
      return new ResponseEntity<>(new register_response(true, "Mail has been sent"), HttpStatus.OK);
    }

    @PostMapping("/cors")
    public ResponseEntity<String> cors(@RequestBody String word){

        return new ResponseEntity<>(word, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<List<Post>> test(){

        List<Post> posts = (List<Post>) postRepository.findAll();

      return ResponseEntity.ok().body(posts);
    }
}
