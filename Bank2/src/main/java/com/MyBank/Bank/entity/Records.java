package com.MyBank.Bank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table (name = "records")
public class Records {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int dt;

    private Long sum;

    @OneToOne (fetch = FetchType.EAGER)
    private Accounts acc;

    @Column (name = "oper_date")
    private Date operDate;

    public Records(Long id, int dt, Long sum, Accounts acc, Date operDate) {
        this.id = id;
        this.dt = dt;
        this.sum = sum;
        this.acc = acc;
        this.operDate = operDate;
    }
}
