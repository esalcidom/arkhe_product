package com.product.arkhe.com_product_arkhe.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.Stock;
import com.product.arkhe.com_product_arkhe.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * StockController
 */
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(value = "/stock", produces = "application/json")
    public List<Stock> getAllStock(){
        return stockService.findAll();
    }

    @GetMapping(value="/stock/{id}", produces = "application/json")
    public Optional<Stock> getStock(@PathVariable long id) throws Exception {
        Optional<Stock> stock = stockService.findById(id);
        if(!stock.isPresent())
            throw new Exception("No attribute found");
        return stock;
    }
    
    @PostMapping(value="/stock", produces = "application/json")
    public ResponseEntity<Object> createStock(@RequestBody Stock stock) {
        Stock newStock = stockService.save(stock);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("attr/{id}").buildAndExpand(newStock.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping(value = "/stock/{id}", produces = "application/json")
    public void deleteStock(@PathVariable long id){
        stockService.deleteById(id);
    }

    @PutMapping(value="/stock/{id}")
    public ResponseEntity<Object> updateStock(@PathVariable long id, @RequestBody Stock stock) throws Exception {
        Optional<Stock> opStock = stockService.findById(id);
        if(!opStock.isPresent())
            throw new Exception("No attribute found");
        stockService.save(stock);
        return ResponseEntity.noContent().build();
    }
}