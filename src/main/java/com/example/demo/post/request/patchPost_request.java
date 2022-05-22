package com.example.demo.post.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class patchPost_request {

    @NotNull(message = "Please, provide an id")
    @Min(value = 0, message = "Min value is 0")
    private Long post_id;

    @Size(min = 3, max = 255, message = "Header's size must be between 3 and 255 symbols")
    private String header;

    @Size(max = 10000, message = "Maximum post's length is 10000 symbols")
    private String content;

    public patchPost_request() {
    }

    public patchPost_request(Long post_id, String header, String content) {
        this.post_id = post_id;
        this.header = header;
        this.content = content;
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

    @Override
    public String toString() {
        return "patchPost_request{" +
                "post_id=" + post_id +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
