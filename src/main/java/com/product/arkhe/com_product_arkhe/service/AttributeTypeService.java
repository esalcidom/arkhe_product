package com.product.arkhe.com_product_arkhe.service;

import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.AttributeType;
import com.product.arkhe.com_product_arkhe.reposotory.AttributeTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AttributeTypeService
 */
@Service
public class AttributeTypeService {

    @Autowired
    private AttributeTypeRepository attrTypeRepo;

    public List<AttributeType> findAll(){   
        return attrTypeRepo.findAll();
    }

    public Optional<AttributeType> findById(long id){
        return attrTypeRepo.findById(id);
    }

    public AttributeType save(AttributeType attr){
        attr.setName(attr.getName().toUpperCase());
        return attrTypeRepo.save(attr);
    }

    public void deleteById(long id){
        attrTypeRepo.deleteById(id);
    }
}