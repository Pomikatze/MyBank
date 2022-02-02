package com.MyBank.Bank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column (name = "place_of_birth")
    private String placeOfBirth;

    @Column (name = "date_of_Birth")
    private Date dateOfBirth;

    private String address;

    private String passport;

    public Clients(Long id, String name, String placeOfBirth, Date dateOfBirth, String address, String passport) {
        this.id = id;
        this.name = name;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.passport = passport;
    }
}
