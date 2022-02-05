package com.MyBank.Bank.service;

import com.MyBank.Bank.entity.ProductType;
import com.MyBank.Bank.repositories.ProdTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdTypeService {
    ProdTypeRepo prodTypeRepo;

    @Autowired
    public ProdTypeService(ProdTypeRepo prodTypeRepo) {
        this.prodTypeRepo = prodTypeRepo;
    }

    public List<ProductType> findAll (){
        return prodTypeRepo.findAll();
    }

    public ProductType findById (Long id){
        return prodTypeRepo.findById(id).get();
    }

    public ProductType saveOrUpdate (ProductType productType){
        return prodTypeRepo.saveAndFlush(productType);
    }

    public void deleteProductType (Long id){
        prodTypeRepo.delete(prodTypeRepo.getById(id));
    }
}
