package com.ecommerce.mashopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.mashopapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
