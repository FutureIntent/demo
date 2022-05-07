package com.example.demo.user.response;

import com.example.demo.user.repository.show_user;

import java.util.List;

public class showUsers_response {

    private Long totalItems;
    private List<show_user> users;
    private Integer totalPages;
    private Integer currentPage;
    private String message;

    public showUsers_response(Long totalItems, List<show_user> users, Integer totalPages, Integer currentPage, String message) {
        this.totalItems = totalItems;
        this.users = users;
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

    public List<show_user> getUsers() {
        return users;
    }

    public void setUsers(List<show_user> users) {
        this.users = users;
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
}
