package com.MyBank.Bank.repositories;

import com.MyBank.Bank.entity.Records;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepo extends JpaRepository<Records,Long> {
}
