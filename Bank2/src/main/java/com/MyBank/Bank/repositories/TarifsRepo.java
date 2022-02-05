package com.MyBank.Bank.repositories;

import com.MyBank.Bank.entity.Tarifs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarifsRepo extends JpaRepository<Tarifs,Long> {
}
