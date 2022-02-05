package com.MyBank.Bank.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductTypeDTO {
    private Long id;
    private String name;
    private Date openDate;
    private Date closeDate;
    private Long tarif;

    public ProductTypeDTO(Long id, String name, Date openDate, Date closeDate, Long tarif) {
        this.id = id;
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.tarif = tarif;
    }

    public ProductTypeDTO(String name, Long tarif) {
        this.name = name;
        this.openDate = new Date();
        this.tarif = tarif;
    }

    public ProductTypeDTO() {
        this.openDate = new Date();
    }
}
