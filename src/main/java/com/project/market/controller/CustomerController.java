package com.project.market.controller;

import com.project.market.dto.CustomerDto;
import com.project.market.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class CustomerController {

    @Autowired
    private  CustomerService customerService;


    @GetMapping("/AllCustomers")
    public String getAllCustomers(Model model) {
        List<CustomerDto> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "AllCustomers";
    }
}

