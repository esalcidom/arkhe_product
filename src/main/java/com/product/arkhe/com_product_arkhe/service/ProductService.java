package com.product.arkhe.com_product_arkhe.service;

import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.Product;
import com.product.arkhe.com_product_arkhe.reposotory.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){   
        return productRepository.findAll();
    }

    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }

    public Product save(Product prod){
        prod.setName(prod.getName().toUpperCase());
        return productRepository.save(prod);
    }

    public void deleteById(long id){
        productRepository.deleteById(id);
    }
}