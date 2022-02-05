package com.MyBank.Bank.service;

import com.MyBank.Bank.entity.Role;
import com.MyBank.Bank.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> findAll (){
        return roleRepo.findAll();
    }

    public Role findById (Long id){
        return roleRepo.findById(id).get();
    }

    public Role saveOrUpdate (Role role){
        return roleRepo.saveAndFlush(role);
    }

    public void deleteRole (Long id){
        roleRepo.delete(roleRepo.getById(id));
    }
}
