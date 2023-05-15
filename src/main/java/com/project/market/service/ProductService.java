package com.project.market.service;

import com.project.market.dto.CustomerDto;
import com.project.market.dto.ProductsDto;
import com.project.market.model.Products;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Products> getAllProducts();

    Products addProduct(Products products);

    void saveProduct(Products product);

    void deleteProductById(Long id);

    Products getProductById(Long id);


    void updateProduct(ProductsDto Dto) throws IOException;

    List<CustomerDto> getAllCustomers();

    public List<Products> searchByName(String query);

    List<Products> searchProducts(String keyword);
    List<Products> searchProductsByName(String name);
}
