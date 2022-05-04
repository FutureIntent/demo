package com.example.demo.user.passwordHashing;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class passwordHasher {

    public String hash(String password){
        String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt(10));
        return pw_hash;
    }

    public Boolean compare(String requested_password, String stored_password){
        if (BCrypt.checkpw(requested_password, stored_password))
            return true;
        else
            return false;
    }

}
