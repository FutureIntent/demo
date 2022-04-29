package com.example.demo.user.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(updatable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 255, updatable = true, unique = true)
    @NotBlank(message = "Please, provide an email")
    @Size(min=5,max=255, message = "Email size must be between 5 and 255 symbols")
    @Email(message = "Please, provide a valid email")
    private String Email;

    @NotBlank(message = "Please, provide a password")
    @Size(min=5, max=255, message = "Password size must be between 5 and 255 symbols")
    @Column(nullable = false, length = 255, updatable = true)
    private String Password;

    public User(String email, String password) {
        Email = email;
        Password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
