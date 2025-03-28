package com.example.product_catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_catalog.entity.Product;
import com.example.product_catalog.repository.ProductRepository;

@Service
public class ProductService {
	
	 private final ProductRepository productRepository;
	    
	    @Autowired
	    public ProductService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }
	    
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
	    
	    public List<Product> getProductsByCategory(String category) {
	        return productRepository.findByCategory(category);
	    }
	    
	    public Product saveProduct(Product product) {
	        return productRepository.save(product);
	    }

}
