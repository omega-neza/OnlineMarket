package com.project.market.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.project.market.dto.CustomerDto;
import com.project.market.dto.ProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.market.model.Products;
import com.project.market.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products addProduct(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public void saveProduct(Products product) {
        productsRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public Products getProductById(Long id) {
        Optional<Products> optionalProduct = productsRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("Invalid product id: " + id);
        }
        return optionalProduct.get();
    }



    @Override
    public void updateProduct(ProductsDto productsDto) throws IOException {
     Products products = mapToProducts(productsDto);
     productsRepository.save(products);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return null;
    }

    @Override
    public List<Products> searchByName(String query) {
        return null;
    }
    public List<Products> searchProductsByName(String name) {
        return productsRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Products> searchProducts(String keyword) {
        List<Products> productList = productsRepository.findByNameContainingIgnoreCase(keyword);
        return productList;
    }

    private Products mapToProducts(ProductsDto products) throws IOException {
        Products product = Products.builder()
                .id(products.getId())
                .name(products.getName())
                .description(products.getDescription())
                .pricePerUnit(products.getPricePerUnit())
                .category(products.getCategory())
                .build();

        // Validate and set the pic field
        MultipartFile picFile = products.getPic();
        if (picFile != null && !picFile.isEmpty()) {
            byte[] picBytes = picFile.getBytes();
            String contentType = picFile.getContentType();
            if (contentType != null && (contentType.equals("image/png") || contentType.equals("image/jpeg"))) {
                product.setPic(picBytes);
            } else {
                throw new IllegalArgumentException("Picture must be a valid image type (PNG or JPEG)");
            }
        }
        return product;
    }

}
