package com.ecommerce.mashopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.mashopapi.entity.Type;

public interface TypeRepository extends JpaRepository<Type, Integer>{
    
}
