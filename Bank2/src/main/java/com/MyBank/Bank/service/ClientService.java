package com.MyBank.Bank.service;

import com.MyBank.Bank.entity.Clients;
import com.MyBank.Bank.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Clients> findAll (){
        return clientRepo.findAll();
    }

    public Clients findById (Long id){
        return clientRepo.findById(id).get();
    }

    public Clients saveOrUpdate (Clients person){
        return clientRepo.saveAndFlush(person);
    }

    public void deletePerson (Long id){
        clientRepo.delete(clientRepo.getById(id));
    }
}
