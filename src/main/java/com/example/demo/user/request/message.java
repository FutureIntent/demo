package com.example.demo.user.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class message {

    @NotBlank(message = "Please, provide a receiver")
    @Size(min = 1, max = 100, message = "Receiver's length has to be between 1 and 100 symbols")
    private String to;

    @NotBlank(message = "Please, provide a subject")
    @Size(min = 1, max = 100, message = "Subject's length has to be between 1 and 100 symbols")
    private String subject;

    @Size(max = 1000, message = "Text's max value is 1000 symbols")
    private String text;

    public message() {
    }

    public message(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "message{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
