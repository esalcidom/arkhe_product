package com.product.arkhe.com_product_arkhe.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.Group;
import com.product.arkhe.com_product_arkhe.service.GroupService;

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
 * GroupController
 */
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping(value = "/group", produces = "application/json")
    public List<Group> getAllGroups(){
        return groupService.findAll();
    }

    @GetMapping(value="/group/{id}", produces = "application/json")
    public Optional<Group> getGroup(@PathVariable long id) throws Exception {
        Optional<Group> group = groupService.findById(id);
        if(!group.isPresent())
            throw new Exception("No attribute found");
        return group;
    }
    
    @PostMapping(value="/group", produces = "application/json")
    public ResponseEntity<Object> createGroup(@RequestBody Group group) {
        Group newGroup = groupService.save(group);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("group/{id}").buildAndExpand(newGroup.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping(value = "/group/{id}", produces = "application/json")
    public void deleteGroup(@PathVariable long id){
        groupService.deleteById(id);
    }

    @PutMapping(value="/group/{id}")
    public ResponseEntity<Object> updateGroup(@PathVariable long id, @RequestBody Group group) throws Exception {
        Optional<Group> opGroup = groupService.findById(id);
        if(!opGroup.isPresent())
            throw new Exception("No attribute found");
        groupService.save(group);
        return ResponseEntity.noContent().build();
    }
}