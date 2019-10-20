package com.product.arkhe.com_product_arkhe.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Attribute> findById(long id){
        return attrRepository.findById(id);
    }

    public Attribute save(Attribute attr){
        attr.setName(attr.getName().toUpperCase());
        return attrRepository.save(attr);
    }

    public void deleteById(long id){
        attrRepository.deleteById(id);
    }
}