package com.product.arkhe.com_product_arkhe.reposotory;

import com.product.arkhe.com_product_arkhe.model.AttributeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductAttributeValueRepository
 */
@Repository
public interface AttributeTypeRepository extends JpaRepository<AttributeType, Long>{
    
}