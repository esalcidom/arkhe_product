package com.product.arkhe.com_product_arkhe.controller;

import java.util.List;

import com.product.arkhe.com_product_arkhe.model.Attribute;
import com.product.arkhe.com_product_arkhe.service.AttributeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * AttributeController
 */
@RestController
public class AttributeController {

    @Autowired
    private AttributeService attrService;

    @RequestMapping(value="/attr", method = RequestMethod.GET, produces = "application/json")
    public List<Attribute> getAllAttributes(){
        return attrService.findAll();
    }
}