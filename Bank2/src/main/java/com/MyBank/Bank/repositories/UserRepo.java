package com.MyBank.Bank.repositories;

import com.MyBank.Bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findOneByUserName(String name);
}
