package com.example.demo.user.controller;

import com.example.demo.user.model.myUser;
import com.example.demo.user.response.register_response;
import com.example.demo.user.response.showUsers_response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class user_controller {

    @Autowired
    com.example.demo.user.service.user_service user_service;

    @PostMapping("/register")
    public ResponseEntity<register_response> registration(@Valid @RequestBody myUser user){
        ResponseEntity<register_response> response = user_service.register(user);
        return response;
    }

    @GetMapping("/test")
    public ResponseEntity<register_response> test(Principal principal){
        return new ResponseEntity<>(new register_response(true, principal.getName()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/showUsers")
    public ResponseEntity<showUsers_response> showUsers(@RequestParam(defaultValue = "1") Integer page,
                                                        @RequestParam(defaultValue = "5") Integer size,
                                                        @RequestParam(defaultValue = "email") String sortBy
                                                  ) throws Exception {

        ResponseEntity<showUsers_response> response = user_service.showUsers(page-1, size, sortBy);

        return response;
    }
}
