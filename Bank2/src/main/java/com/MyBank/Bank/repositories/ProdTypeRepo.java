package com.MyBank.Bank.repositories;

import com.MyBank.Bank.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdTypeRepo extends JpaRepository<ProductType,Long> {
}
