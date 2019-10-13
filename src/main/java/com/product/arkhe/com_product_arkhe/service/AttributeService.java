package com.product.arkhe.com_product_arkhe.service;

import java.util.List;

import com.product.arkhe.com_product_arkhe.model.Attribute;
import com.product.arkhe.com_product_arkhe.reposotory.AttributeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AttributeService
 */
@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attrRepository;

    public List<Attribute> findAll(){
        
        return attrRepository.findAll();
    }
}