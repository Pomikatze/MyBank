package com.MyBank.Bank.repositories;

import com.MyBank.Bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findOneByUserName(String name);
}
