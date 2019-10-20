package com.product.arkhe.com_product_arkhe.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.Attribute;
import com.product.arkhe.com_product_arkhe.service.AttributeService;

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
 * AttributeController
 */
@RestController
public class AttributeController {

    @Autowired
    private AttributeService attrService;

    @GetMapping(value = "/attr", produces = "application/json")
    public List<Attribute> getAllAttributes(){
        return attrService.findAll();
    }

    @GetMapping(value="/attr/{id}", produces = "application/json")
    public Optional<Attribute> getAttribute(@PathVariable long id) throws Exception {
        Optional<Attribute> attr = attrService.findById(id);
        if(!attr.isPresent())
            throw new Exception("No attribute found");
        return attr;
    }
    
    @PostMapping(value="/attr", produces = "application/json")
    public ResponseEntity<Object> createAttribute(@RequestBody Attribute attr) {
        Attribute newAttr = attrService.save(attr);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("attr/{id}").buildAndExpand(newAttr.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping(value = "/attr/{id}", produces = "application/json")
    public void deleteAttribute(@PathVariable long id){
        attrService.deleteById(id);
    }

    @PutMapping(value="/attr/{id}")
    public ResponseEntity<Object> updateAttribute(@PathVariable long id, @RequestBody Attribute attr) throws Exception {
        Optional<Attribute> opAttr = attrService.findById(id);
        if(!opAttr.isPresent())
            throw new Exception("No attribute found");
        attrService.save(attr);
        return ResponseEntity.noContent().build();
    }
}