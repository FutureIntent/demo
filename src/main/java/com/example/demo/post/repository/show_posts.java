package com.example.demo.post.repository;

import java.util.Date;

public interface show_posts {
    Long getPost_id();
    String getHeader();
    String getContent();
    Date getCreated_at();
    Long getUser_id();
    String getEmail();
}
