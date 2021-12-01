package com.williamslea.product.controller;

import com.williamslea.product.entity.Product;
import com.williamslea.product.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    
   	Logger logger = LoggerFactory.getLogger(ProductController.class);
    
    /**
     * 
     * List of names of all the products.
     */
	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findAllProducts() {
		logger.debug("Inside find all products");
		return service.getProducts();
	}

    /**
     * 
     * To create a new product.
     */
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
    	logger.debug("Inside add product");
        return service.saveProduct(product);
    }
    
    /**
     * 
     * To find product based on id.
     */
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
    	logger.debug("Inside add product by id");
        return service.getProductById(id);
    }

    /**
     * 
     * To find product based on name.
     */
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
    	logger.debug("Inside find product by name");
        return service.getProductByName(name);
    }
}
