package com.product.arkhe.com_product_arkhe.reposotory;

import java.util.List;

import com.product.arkhe.com_product_arkhe.model.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * StockRepository
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

    List<Stock> findByProductModel(String model);
}