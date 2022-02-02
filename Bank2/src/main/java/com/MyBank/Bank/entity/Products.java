package com.MyBank.Bank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table (name = "products")
public class Products {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne (fetch = FetchType.EAGER)
    private ProductType productType;

    private String name;

    @OneToOne (fetch = FetchType.EAGER)
    private Clients client;

    @Column (name = "open_date")
    private Date openDate;

    @Column (name = "close_date")
    private Date closeDate;

    public Products(Long id, ProductType productType, String name, Clients client, Date openDate, Date closeDate) {
        this.id = id;
        this.productType = productType;
        this.name = name;
        this.client = client;
        this.openDate = openDate;
        this.closeDate = closeDate;
    }
}
