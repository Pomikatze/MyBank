package com.MyBank.Bank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table (name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column (name = "begin_date")
    private Date openDate;

    @Column (name = "end_date")
    private Date closeDate;

    @OneToOne (fetch = FetchType.EAGER)
    private Tarifs tarif;

    public ProductType(Long id, String name, Date openDate, Date closeDate, Tarifs tarif) {
        this.id = id;
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.tarif = tarif;
    }
}
