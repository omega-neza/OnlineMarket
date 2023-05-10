package com.project.market.controller;

import com.project.market.dto.ProductsDto;
import com.project.market.model.Products;
import com.project.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Products());
        return "RegisterProduct";
    }

    @PostMapping("/add_product")
    public String addProduct(@Valid @ModelAttribute("product") Products product, BindingResult bindingResult, @RequestParam("pic") MultipartFile file, Model model) throws IOException {
        if (bindingResult.hasErrors()) {
            return "RegisterProduct";
        }
        product.setPic(file.getBytes());
        productService.addProduct(product);
        model.addAttribute("product", product);
        return "redirect:/AllProducts";
    }

    @GetMapping("/AllProducts")
    public String getAllProducts(Model model) {
        List<Products> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "AllProducts";
    }

    @GetMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/AllProducts";
    }

    @GetMapping("/products/update/{id}")
    public String showUpdateProductForm(@PathVariable("id") Long id, Model model) {
        Products product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "UpdateProduct";
    }

    @PostMapping("/products/update/{id}")
    public String updateProduct(@PathVariable("id") long id, @ModelAttribute("products") ProductsDto products) throws IOException {
        products.setId(id);
        productService.updateProduct(products);
        return "redirect:/AllProducts";

    }
    @GetMapping("/admin")
    public String adminBoard() {
        return "AdminBoard";
    }

}
