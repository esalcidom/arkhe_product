package com.product.arkhe.com_product_arkhe.reposotory;

import com.product.arkhe.com_product_arkhe.model.Attribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AttributeRepository
 */
@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long>{

    
}