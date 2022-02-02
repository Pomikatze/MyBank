package com.MyBank.Bank.repositories;

import com.MyBank.Bank.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Clients,Long> {
}
