package com.example.product_catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.product_catalog.entity.Product;
import com.example.product_catalog.service.ProductService;


import jakarta.validation.Valid;

@Controller
public class ProductController {
	
	@Autowired
	 private final ProductService productService;
	    
	 @Autowired
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }
	    
	    @GetMapping("/")
	    public String index() {
	        return "index";
	    }
	    
	    @GetMapping("/add-product")
	    public String showAddProductForm(Model model) {
	        model.addAttribute("product", new Product());
	        return "add-product";
	    }
	    
	    @PostMapping("/add-product")
	    public String addProduct(@Valid @ModelAttribute("product") Product product, 
	                             BindingResult result, 
	                             Model model) {
	        if (result.hasErrors()) {
	            return "add-product";
	        }
	        
	        productService.saveProduct(product);
	        return "redirect:/display-products";
	    }
	    
	    @GetMapping("/display-products")
	    public String displayProducts(@RequestParam(required = false) String category, Model model) {
	        if (category != null && !category.isEmpty()) {
	            model.addAttribute("products", productService.getProductsByCategory(category));
	        } else {
	            model.addAttribute("products", productService.getAllProducts());
	        }
	        return "display-products";
	    }
	
}
