package com.project.market.controller;

import com.project.market.model.Products;
import com.project.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoriesController {
    @Autowired
    private ProductService productService;
    @GetMapping("/Categories")
    public String getAllProducts(Model model) {
        List<Products> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "Categories";
    }
}
