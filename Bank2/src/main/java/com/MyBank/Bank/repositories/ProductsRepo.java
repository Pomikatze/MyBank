package com.MyBank.Bank.repositories;

import com.MyBank.Bank.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Products,Long> {
}
