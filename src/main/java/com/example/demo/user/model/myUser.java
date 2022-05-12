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
    @Column(updatable = false, unique = true, name="user_id")
    private Long user_id;

    @Column(nullable = false, length = 255, updatable = true, unique = true, name="email")
    @NotBlank(message = "Please, provide an email")
    @Size(min=5,max=255, message = "Email size must be between 5 and 255 symbols")
    @Email(message = "Please, provide a valid email")
    private String email;

    @NotBlank(message = "Please, provide a password")
    @Size(min=5, max=255, message = "Password size must be between 5 and 255 symbols")
    @Column(nullable = false, length = 255, updatable = true, name="password")
    private String password;

    @Size(max=255, message="Status max size is 255 symbols")
    @Column(nullable=true, length = 255, updatable = true, name = "status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(updatable = false, name="created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updated_at;

    @Column(name="black_listed")
    private Boolean black_listed = false;

    @Column(name="role")
    private String role = "user";

    public myUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public myUser() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public Date getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Boolean getBlack_listed() {
        return black_listed;
    }

    public void setBlack_listed(Boolean black_listed) {
        this.black_listed = black_listed;
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
                "id=" + user_id +
                ", Email='" + email + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
