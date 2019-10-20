package com.product.arkhe.com_product_arkhe.reposotory;

import com.product.arkhe.com_product_arkhe.model.ProductAttributeValue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductAttributeValueRepository
 */
@Repository
public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValue, Long>{
    
}