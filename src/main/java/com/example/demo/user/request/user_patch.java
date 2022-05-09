package com.example.demo.user.request;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class user_patch {

    @Size(max=255, message="Status max size is 255 symbols")
    private String status;

    @Size(min=5, max=255, message = "Password size must be between 5 and 255 symbols")
    private String current_password;

    @Size(min=5, max=255, message = "Password size must be between 5 and 255 symbols")
    private String new_password;

    public user_patch(String status, String current_password, String new_password) {
        this.status = status;
        this.current_password = current_password;
        this.new_password = new_password;
    }

    public user_patch() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrent_password() {
        return current_password;
    }

    public void setCurrent_password(String current_password) {
        this.current_password = current_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
}
