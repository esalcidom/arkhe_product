package com.product.arkhe.com_product_arkhe.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.Product;
import com.product.arkhe.com_product_arkhe.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * ProductController
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product", produces = "application/json")
    public List<Product> getAllProduct(){
        List<Product> products = productService.findAll();
        return products;
    }

    @GetMapping(value="/product/{id}", produces = "application/json")
    public Optional<Product> getProduct(@PathVariable long id) throws Exception {
        Optional<Product> prod = productService.findById(id);
        if(!prod.isPresent())
            throw new Exception("No attribute found");
        return prod;
    }
    
    @PostMapping(value="/product", produces = "application/json")
    public ResponseEntity<Object> createProduct(@RequestBody Product prod) {
        Product newProduct = productService.save(prod);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("product/{id}").buildAndExpand(newProduct.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping(value = "/product/{id}", produces = "application/json")
    public void deleteProduct(@PathVariable long id){
        productService.deleteById(id);
    }

    @PutMapping(value="/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable long id, @RequestBody Product prod) throws Exception {
        Optional<Product> opProduct = productService.findById(id);
        if(!opProduct.isPresent())
            throw new Exception("No attribute found");
        productService.save(prod);
        return ResponseEntity.noContent().build();
    }
}