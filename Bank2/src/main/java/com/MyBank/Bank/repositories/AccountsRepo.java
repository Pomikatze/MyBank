package com.MyBank.Bank.repositories;

import com.MyBank.Bank.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepo extends JpaRepository<Accounts,Long> {
}
