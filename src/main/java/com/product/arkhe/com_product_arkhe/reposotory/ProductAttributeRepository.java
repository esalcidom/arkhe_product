package com.product.arkhe.com_product_arkhe.reposotory;

import com.product.arkhe.com_product_arkhe.model.ProductAttribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductAttributeRepository
 */
@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long>{

}