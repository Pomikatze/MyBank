package com.MyBank.Bank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table (name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String saldo;

    @OneToOne(fetch = FetchType.LAZY)
    private Clients client;

    @Column (name = "open_date")
    private Date openDate;

    @Column (name = "close_date")
    private Date closeDate;

    @Column (name = "product_ref")
    private Long productRef;

    @Column (name = "acc_num")
    private String numberOfAcc;

    public Accounts(Long id, String name, String saldo, Clients client, Date openDate, Date closeDate, Long productRef,
                    String numberOfAcc) {
        this.id = id;
        this.name = name;
        this.saldo = saldo;
        this.client = client;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.productRef = productRef;
        this.numberOfAcc = numberOfAcc;
    }
}
