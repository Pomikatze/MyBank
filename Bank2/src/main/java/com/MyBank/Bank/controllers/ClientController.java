package com.MyBank.Bank.controllers;

import com.MyBank.Bank.entity.Clients;
import com.MyBank.Bank.exception.PersonErrorResponse;
import com.MyBank.Bank.exception.PersonNotFoundException;
import com.MyBank.Bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/clients")
@RestController
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Clients getClient (@PathVariable Long id){
        return clientService.findById(id);
    }

    @GetMapping()
    public List<Clients> getAllPersons (){
        return clientService.findAll();
    }

    @PutMapping
    public Clients addPerson (@RequestBody Clients clients){
        return clientService.saveOrUpdate(clients);
    }

    @DeleteMapping("/{id}")
    public int deletePerson (@PathVariable Long id){
        clientService.deletePerson(id);
        return HttpStatus.OK.value();
    }

    @ExceptionHandler
    public ResponseEntity<PersonErrorResponse> handleException (PersonNotFoundException exc){
        PersonErrorResponse personErrorResponse = new PersonErrorResponse();
        personErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        personErrorResponse.setMessage(exc.getMessage());
        personErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(personErrorResponse, HttpStatus.NOT_FOUND);
    }
}
