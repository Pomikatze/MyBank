package com.MyBank.Bank.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ClientDTO {
    private String name;
    private String dateOfBirth;

    public ClientDTO(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}