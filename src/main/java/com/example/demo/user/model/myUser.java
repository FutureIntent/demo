package com.example.demo.user.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="user")
public class myUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(updatable = false, unique = true, name="id")
    private Long id;

    @Column(nullable = false, length = 255, updatable = true, unique = true, name="email")
    @NotBlank(message = "Please, provide an email")
    @Size(min=5,max=255, message = "Email size must be between 5 and 255 symbols")
    @Email(message = "Please, provide a valid email")
    private String email;

    @NotBlank(message = "Please, provide a password")
    @Size(min=5, max=255, message = "Password size must be between 5 and 255 symbols")
    @Column(nullable = false, length = 255, updatable = true, name="password")
    private String password;

    @CreationTimestamp
    @Column(updatable = false, name="created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="black_listed")
    private Boolean blackListed = false;

    @Column(name="role")
    private String role = "user";

    public myUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public myUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", Email='" + email + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
