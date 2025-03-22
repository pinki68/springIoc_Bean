package com.example.product_catalog.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product_catalog.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     
	 // Method to find products by category
    List<Product> findByCategory(String category);

}
