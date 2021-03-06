package com.example.demo.post.model;

import com.example.demo.user.model.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(updatable = false, unique = true, name="post_id")
    private Long post_id;

    @NotBlank(message = "Please, provide a header")
    @Size(min = 3, max = 255, message = "Header's size must be between 3 and 255 symbols")
    @Column(name="header")
    private String header;

    @Size(max = 10000, message = "Maximum post's length is 10000 symbols")
    @Column(name = "content", columnDefinition="TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(updatable = false, name="created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updated_at;

    public Post() {
    }

    public Post(Long post_id, String header, String content, User user, Date created_at, Date updated_at) {
        this.post_id = post_id;
        this.header = header;
        this.content = content;
        this.user = user;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated_at() {
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

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
