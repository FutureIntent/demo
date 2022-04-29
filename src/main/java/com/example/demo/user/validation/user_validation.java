package com.example.demo.user.validation;

import com.example.demo.user.model.User;
import com.example.demo.user.response.response;
import org.springframework.stereotype.Service;

@Service
public class user_validation {
    public response validate(User user){
    String password = user.getPassword();

    for(int i=0; i < password.length(); i++){
        if(password.charAt(i) == ' '){
            return new response(false, "Password cannot contain white spaces");
        }
    }
        return new response(true, "Success");
    }
}
