package com.MyBank.Bank.service;

import com.MyBank.Bank.entity.Tarifs;
import com.MyBank.Bank.repositories.TarifsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifsService {
    TarifsRepo tarifsRepo;

    @Autowired
    public TarifsService(TarifsRepo tarifsRepo) {
        this.tarifsRepo = tarifsRepo;
    }

    public List<Tarifs> findAll (){
        return tarifsRepo.findAll();
    }

    public Tarifs findById (Long id){
        return tarifsRepo.findById(id).get();
    }

    public Tarifs saveOrUpdate (Tarifs tarif){
        return tarifsRepo.saveAndFlush(tarif);
    }

    public void deleteTarif (Long id){
        tarifsRepo.delete(tarifsRepo.getById(id));
    }
}
