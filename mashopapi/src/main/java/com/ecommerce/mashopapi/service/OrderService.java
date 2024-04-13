package com.ecommerce.mashopapi.service;

import java.util.List;

import com.ecommerce.mashopapi.entity.Order;
import com.ecommerce.mashopapi.model.OrderResponse;

public interface OrderService {
    
    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(String id);

    void deleteOrderById(String id);

    OrderResponse createOrder(Order order);
}
