package com.example.demo.user.validation;

import com.example.demo.user.model.myUser;
import com.example.demo.user.response.register_response;
import org.springframework.stereotype.Component;

@Component
public class user_validation {
    public register_response validate(myUser user){
    String password = user.getPassword();

    for(int i=0; i < password.length(); i++){
        if(password.charAt(i) == ' '){
            return new register_response(false, "Password cannot contain white spaces");
        }
    }
        return new register_response(true, "Success");
    }
}
