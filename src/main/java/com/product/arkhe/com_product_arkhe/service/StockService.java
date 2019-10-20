package com.product.arkhe.com_product_arkhe.service;

import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.Stock;
import com.product.arkhe.com_product_arkhe.reposotory.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StockService
 */
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepo;

    public List<Stock> findAll(){   
        return stockRepo.findAll();
    }

    public Optional<Stock> findById(long id){
        return stockRepo.findById(id);
    }

    public Stock save(Stock stock){
        return stockRepo.save(stock);
    }

    public void deleteById(long id){
        stockRepo.deleteById(id);
    }    
}