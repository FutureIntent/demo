package com.example.demo.post.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class showPost_request {
    @NotBlank(message = "Please, provide an email")
    @Size(min=5, max=255, message = "Email size must be between 5 and 255 symbols")
    @Email(message = "Please, provide a valid email")
    private String email;

    public showPost_request() {
    }

    public showPost_request(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "showUser_request{" +
                "email='" + email + '\'' +
                '}';
    }
}
