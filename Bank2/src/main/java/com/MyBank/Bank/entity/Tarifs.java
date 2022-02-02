package com.MyBank.Bank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table (name = "tarifs")
public class Tarifs {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long cost;

    public Tarifs(Long id, String name, Long cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
