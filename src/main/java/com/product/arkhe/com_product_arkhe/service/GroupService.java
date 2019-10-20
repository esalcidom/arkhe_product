package com.product.arkhe.com_product_arkhe.service;

import java.util.List;
import java.util.Optional;

import com.product.arkhe.com_product_arkhe.model.Group;
import com.product.arkhe.com_product_arkhe.reposotory.GroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GroupService
 */
@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepo;

    public List<Group> findAll(){   
        return groupRepo.findAll();
    }

    public Optional<Group> findById(long id){
        return groupRepo.findById(id);
    }

    public Group save(Group group){
        group.setName(group.getName().toUpperCase());
        return groupRepo.save(group);
    }

    public void deleteById(long id){
        groupRepo.deleteById(id);
    }    
}