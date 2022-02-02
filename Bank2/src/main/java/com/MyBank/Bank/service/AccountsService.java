package com.MyBank.Bank.service;

import com.MyBank.Bank.entity.Accounts;
import com.MyBank.Bank.repositories.AccountsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {
    AccountsRepo accountsRepo;

    @Autowired
    public AccountsService(AccountsRepo accountsRepo) {
        this.accountsRepo = accountsRepo;
    }

    public List<Accounts> findAll (){
        return accountsRepo.findAll();
    }

    public Accounts findById (Long id){
        return accountsRepo.findById(id).get();
    }

    public Accounts saveOrUpdate (Accounts accounts){
        return accountsRepo.saveAndFlush(accounts);
    }

    public void deleteAccount (Long id){
        accountsRepo.delete(accountsRepo.getById(id));
    }
}
