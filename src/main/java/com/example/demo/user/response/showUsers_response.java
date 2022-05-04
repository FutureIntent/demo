package com.example.demo.user.response;

import com.example.demo.user.model.myUser;

import java.util.List;

public class showUsers_response {

    private Long totalItems;
    private List<myUser> users;
    private Integer totalPages;
    private Integer currentPage;
    private String message;

    public showUsers_response(Long totalItems, List<myUser> users, Integer totalPages, Integer currentPage, String message) {
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

    public List<myUser> getUsers() {
        return users;
    }

    public void setUsers(List<myUser> users) {
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
