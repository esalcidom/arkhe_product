package com.product.arkhe.com_product_arkhe.service;

import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.Category;
import com.product.arkhe.com_product_arkhe.reposotory.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategoryService
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> findAll(){   
        return categoryRepo.findAll();
    }

    public Optional<Category> findById(long id){
        return categoryRepo.findById(id);
    }

    public Category save(Category category){
        category.setName(category.getName().toUpperCase());
        return categoryRepo.save(category);
    }

    public void deleteById(long id){
        categoryRepo.deleteById(id);
    }
    
}