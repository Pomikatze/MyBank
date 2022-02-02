package com.MyBank.Bank.service;

import com.MyBank.Bank.entity.Products;
import com.MyBank.Bank.repositories.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    ProductsRepo productsRepo;

    @Autowired
    public ProductsService(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    public List<Products> findAll (){
        return productsRepo.findAll();
    }

    public Products findById (Long id){
        return productsRepo.findById(id).get();
    }

    public Products saveOrUpdate (Products product){
        return productsRepo.saveAndFlush(product);
    }

    public void deleteProduct (Long id){
        productsRepo.delete(productsRepo.getById(id));
    }
}
