package com.example.demo.user.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    private Boolean blackListed = false;

    private Boolean verified = false;

    private String role = "user";

    public User(String email, String password) {
        Email = email;
        Password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getBlackListed() {
        return blackListed;
    }

    public void setBlackListed(Boolean blackListed) {
        this.blackListed = blackListed;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
