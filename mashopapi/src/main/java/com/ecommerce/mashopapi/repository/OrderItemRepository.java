package com.ecommerce.mashopapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.mashopapi.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{
    
}
