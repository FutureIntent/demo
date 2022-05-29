package com.example.demo.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "product_food")
public class Product_food extends Product{

   @Max(value = 1000000, message = "Max calories value is 1 mil.")
   @Column(name = "calories")
   private Long calories;

   @Column(name = "compound")
   @Size(max = 255, message = "Max product's compound is 255 symbols")
   private String compound;

   @NotEmpty(message = "Please, provide product's shelf life")
   @Column(nullable = false, columnDefinition = "DATE", name = "shelf_life")
   @Pattern(regexp = "\\d{4}-[0-12]{2}-[0-31]{2}", message = "Required date format is \"yyyy-MM-dd\" ")
   private String shelf_life;

   public Product_food() {
   }

   public Product_food(Long product_id, String title, String description, Date created_at, Date updated_at, Long calories, String compound, String shelf_life) {
      super(product_id, title, description, created_at, updated_at);
      this.calories = calories;
      this.compound = compound;
      this.shelf_life = shelf_life;
   }

   public Long getCalories() {
      return calories;
   }

   public void setCalories(Long calories) {
      this.calories = calories;
   }

   public String getCompound() {
      return compound;
   }

   public void setCompound(String compound) {
      this.compound = compound;
   }

   public String getShelf_life() {
      return shelf_life;
   }

   public void setShelf_life(String shelf_life) {
      this.shelf_life = shelf_life;
   }

   @Override
   public String toString() {
      return "Product_food{" +
              "calories=" + calories +
              ", compound='" + compound + '\'' +
              ", shelf_life='" + shelf_life + '\'' +
              '}';
   }
}
