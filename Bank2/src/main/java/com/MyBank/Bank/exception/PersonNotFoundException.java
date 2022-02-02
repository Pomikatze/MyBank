package com.MyBank.Bank.exception;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException (String message){
        super(message);
    }
}
