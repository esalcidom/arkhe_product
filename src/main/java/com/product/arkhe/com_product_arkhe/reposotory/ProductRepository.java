package com.product.arkhe.com_product_arkhe.reposotory;

import com.product.arkhe.com_product_arkhe.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    
}