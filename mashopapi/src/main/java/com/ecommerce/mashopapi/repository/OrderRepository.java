package com.ecommerce.mashopapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.mashopapi.entity.Order;

public interface OrderRepository extends CrudRepository<Order, String>{
    
}
