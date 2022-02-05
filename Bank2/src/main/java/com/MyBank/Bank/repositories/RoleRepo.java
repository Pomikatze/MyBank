package com.MyBank.Bank.repositories;

import com.MyBank.Bank.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    public Role findOneByName(String name);
}
