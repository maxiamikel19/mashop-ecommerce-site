package com.ecommerce.mashopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.mashopapi.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
    
}
