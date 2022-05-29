package com.example.demo.product.response;

public class creation_response {

    private boolean status;

    private String message;

    public creation_response() {
    }

    public creation_response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "creation_response{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
