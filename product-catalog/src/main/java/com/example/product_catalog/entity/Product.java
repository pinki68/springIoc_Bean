package com.example.product_catalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "products")
public class Product {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	    
	    @NotBlank(message = "Product name is required")
	    private String name;
	    
	    @Positive(message = "Price must be greater than zero")
	    private Double price;
	    
	    @NotBlank(message = "Category is required")
	    private String category;
	    
	    // Default constructor
	    public Product() {
	    }
	    
	    // Constructor with fields
	    public Product(String name, Double price, String category) {
	        this.name = name;
	        this.price = price;
	        this.category = category;
	    }
	    
	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public Double getPrice() {
	        return price;
	    }
	    
	    public void setPrice(Double price) {
	        this.price = price;
	    }
	    
	    public String getCategory() {
	        return category;
	    }
	    
	    public void setCategory(String category) {
	        this.category = category;
	    }
	    

}
