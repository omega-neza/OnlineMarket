package com.project.market.repository;


import com.project.market.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    List<Products> findByCategory(String category);
    List<Products> findByNameContainingIgnoreCase(String name);



}
