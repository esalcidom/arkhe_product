package com.product.arkhe.com_product_arkhe.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.Category;
import com.product.arkhe.com_product_arkhe.service.CategoryService;

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
 * CategoryController
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/category", produces = "application/json")
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping(value="/category/{id}", produces = "application/json")
    public Optional<Category> getCategory(@PathVariable long id) throws Exception {
        Optional<Category> cat = categoryService.findById(id);
        if(!cat.isPresent())
            throw new Exception("No attribute found");
        return cat;
    }
    
    @PostMapping(value="/category", produces = "application/json")
    public ResponseEntity<Object> createAttribute(@RequestBody Category cat) {
        Category newCat = categoryService.save(cat);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("category/{id}").buildAndExpand(newCat.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping(value = "/category/{id}", produces = "application/json")
    public void deleteAttribute(@PathVariable long id){
        categoryService.deleteById(id);
    }

    @PutMapping(value="/category/{id}")
    public ResponseEntity<Object> updateAttribute(@PathVariable long id, @RequestBody Category cat) throws Exception {
        Optional<Category> opCat = categoryService.findById(id);
        if(!opCat.isPresent())
            throw new Exception("No attribute found");
        categoryService.save(cat);
        return ResponseEntity.noContent().build();
    }    
}