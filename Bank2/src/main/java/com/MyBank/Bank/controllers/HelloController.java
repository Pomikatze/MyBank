package com.MyBank.Bank.controllers;

import com.MyBank.Bank.dto.ClientDTO;
import com.MyBank.Bank.entity.Clients;
import com.MyBank.Bank.entity.Products;
import com.MyBank.Bank.entity.Tarifs;
import com.MyBank.Bank.service.ProductsService;
import com.MyBank.Bank.service.TarifsService;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/")
@Controller
public class HelloController {
    TarifsService tarifsService;
    ClientController clientController;
    ProductsService productsService;

    @Autowired
    public HelloController(TarifsService tarifsService, ClientController clientController, ProductsService productsService) {
        this.tarifsService = tarifsService;
        this.clientController = clientController;
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String index (Model model){
        List<Tarifs> tarifs = tarifsService.findAll();
        model.addAttribute("tarifs", tarifs);
        return "index";
    }
}
