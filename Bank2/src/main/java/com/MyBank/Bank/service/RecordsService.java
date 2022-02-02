package com.MyBank.Bank.service;

import com.MyBank.Bank.entity.Records;
import com.MyBank.Bank.repositories.RecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsService {
    RecordsRepo recordsRepo;

    @Autowired
    public RecordsService(RecordsRepo recordsRepo) {
        this.recordsRepo = recordsRepo;
    }

    public List<Records> findAll (){
        return recordsRepo.findAll();
    }

    public Records findById (Long id){
        return recordsRepo.findById(id).get();
    }

    public Records saveOrUpdate (Records records){
        return recordsRepo.saveAndFlush(records);
    }

    public void deleteRecords (Long id){
        recordsRepo.delete(recordsRepo.getById(id));
    }
}
