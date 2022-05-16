package com.example.demo.post.response;

import com.example.demo.post.repository.show_posts;
import com.example.demo.user.repository.show_user;

import java.util.List;

public class showPosts_response {
    private Long totalItems;
    private List<show_posts> posts;
    private Integer totalPages;
    private Integer currentPage;
    private String message;

    public showPosts_response() {
    }

    public showPosts_response(Long totalItems, List<show_posts> posts, Integer totalPages, Integer currentPage, String message) {
        this.totalItems = totalItems;
        this.posts = posts;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.message = message;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public List<show_posts> getPosts() {
        return posts;
    }

    public void setPosts(List<show_posts> posts) {
        this.posts = posts;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "showPosts_response{" +
                "totalItems=" + totalItems +
                ", posts=" + posts +
                ", totalPages=" + totalPages +
                ", currentPage=" + currentPage +
                ", message='" + message + '\'' +
                '}';
    }
}
