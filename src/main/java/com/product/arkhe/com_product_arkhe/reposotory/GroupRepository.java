package com.product.arkhe.com_product_arkhe.reposotory;

import com.product.arkhe.com_product_arkhe.model.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * GroupRepository
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
    
}