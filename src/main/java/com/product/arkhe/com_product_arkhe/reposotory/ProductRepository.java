package com.product.arkhe.com_product_arkhe.reposotory;

import java.util.List;

import com.product.arkhe.com_product_arkhe.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByModel(String model);
    List<Product> findByGroupName(String group);
    List<Product> findByCategoryName(String category);
}