package com.example.demo.product.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(updatable = false, unique = true, name="product_id")
    private Long product_id;

    @NotBlank(message = "Product's title is required")
    @Size(min = 1, max = 50, message = "Title's size must be between 1 and 50 symbols")
    @Column(nullable = false, name = "title")
    private String title;

    @NotBlank(message = "Product's description is required")
    @Size(min = 1, max = 255, message = "Description's size must be between 1 and 255 symbols")
    @Column(nullable = false, name = "description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(updatable = false, name="created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updated_at;

    public Product() {
    }

    public Product(Long product_id, String title, String description, Date created_at, Date updated_at) {
        this.product_id = product_id;
        this.title = title;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Product{" +
                "product_id=" + product_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
