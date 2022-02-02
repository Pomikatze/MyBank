package com.MyBank.Bank.controllers;

import com.MyBank.Bank.dto.ProductTypeDTO;
import com.MyBank.Bank.entity.Clients;
import com.MyBank.Bank.entity.ProductType;
import com.MyBank.Bank.service.ClientService;
import com.MyBank.Bank.service.ProdTypeService;
import com.MyBank.Bank.service.TarifsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/api/v1/")
@Controller
public class AdminController {
    ProdTypeService prodTypeService;
    TarifsService tarifsService;
    ClientService clientService;

    @Autowired
    public AdminController(ProdTypeService prodTypeService, TarifsService tarifsService, ClientService clientService) {
        this.prodTypeService = prodTypeService;
        this.tarifsService = tarifsService;
        this.clientService = clientService;
    }

    @GetMapping ("/admin")
    public String admin (Model model){
        List<ProductType> productTypes = prodTypeService.findAll();
        List<ProductTypeDTO> productTypesDTO = new ArrayList<>();
        List<Clients> clients = clientService.findAll();

        for (ProductType productType : productTypes){
            productTypesDTO.add(new ProductTypeDTO(productType.getId(), productType.getName(), productType.getOpenDate(),
                    productType.getCloseDate(), productType.getTarif().getId()));
        }
        model.addAttribute("productTypesDTO", productTypesDTO);
        model.addAttribute("productTypeDTO", new ProductTypeDTO());
        model.addAttribute("clients", clients);
        return "admin";
    }

    @PostMapping ("/admin")
    public String addProdType (ProductTypeDTO productType){
        ProductType pd = new ProductType(null, productType.getName(), productType.getOpenDate(),
                null, tarifsService.findById(productType.getTarif()));
        prodTypeService.saveOrUpdate(pd);
        return "admin";
    }
}
