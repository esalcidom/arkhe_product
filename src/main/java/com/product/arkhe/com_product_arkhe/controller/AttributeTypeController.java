package com.product.arkhe.com_product_arkhe.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.AttributeType;
import com.product.arkhe.com_product_arkhe.service.AttributeTypeService;

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
 * AttributeTypeController
 */
@RestController
public class AttributeTypeController {

    @Autowired
    private AttributeTypeService attrTypeService;

    @GetMapping(value = "/attrType", produces = "application/json")
    public List<AttributeType> getAllAttributeTypes(){
        return attrTypeService.findAll();
    }

    @GetMapping(value="/attrType/{id}", produces = "application/json")
    public Optional<AttributeType> getAttributeType(@PathVariable long id) throws Exception {
        Optional<AttributeType> attr = attrTypeService.findById(id);
        if(!attr.isPresent())
            throw new Exception("No attribute found");
        return attr;
    }
    
    @PostMapping(value="/attrType", produces = "application/json")
    public ResponseEntity<Object> createAttributeType(@RequestBody AttributeType attr) {
        AttributeType newAttr = attrTypeService.save(attr);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("attrType/{id}").buildAndExpand(newAttr.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping(value = "/attrType/{id}", produces = "application/json")
    public void deleteAttributeType(@PathVariable long id){
        attrTypeService.deleteById(id);
    }

    @PutMapping(value="/attrType/{id}")
    public ResponseEntity<Object> updateAttributeType(@PathVariable long id, @RequestBody AttributeType attr) throws Exception {
        Optional<AttributeType> opAttr = attrTypeService.findById(id);
        if(!opAttr.isPresent())
            throw new Exception("No attribute found");
        attrTypeService.save(attr);
        return ResponseEntity.noContent().build();
    }
}