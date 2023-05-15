package com.project.market.controller;

import com.project.market.dto.ProductsDto;
import com.project.market.model.Products;
import com.project.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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


    @GetMapping("/add_product")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Products());
        return "RegisterProduct";
    }

    @PostMapping("/add_product")
    public String addProduct(@ModelAttribute("product") Products product) {
        productService.addProduct(product);
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




    @RequestMapping(value = "/product/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getProductImage(@PathVariable("id") Long id) throws IOException {
        Products product = productService.getProductById(id);
        return product.getPic();
    }

    @GetMapping("/search")
    public String search() {
        return "Categories";
    }


}
