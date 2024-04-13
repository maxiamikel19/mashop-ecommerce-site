package com.ecommerce.mashopapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mashopapi.entity.Order;
import com.ecommerce.mashopapi.entity.OrderItem;
import com.ecommerce.mashopapi.model.OrderItemResponse;
import com.ecommerce.mashopapi.model.OrderResponse;
import com.ecommerce.mashopapi.service.OrderServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponse> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public OrderResponse getOrderById(@PathVariable String orderId){
        return orderService.getOrderById(orderId);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrderById(@PathVariable String orderId){
        orderService.deleteOrderById(orderId);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderResponse orderResponse){
        Order order = convertToOrder(orderResponse);
        OrderResponse newOrder = orderService.createOrder(order);
        return new ResponseEntity<> (newOrder, HttpStatus.CREATED);
    }

    private Order convertToOrder(OrderResponse orderResponse) {
        Order order = new Order();
        order.setId(orderResponse.getId());
        order.setItems(convertToOrdersItems(orderResponse.getItems()));
        return order;
    }

    private List<OrderItem> convertToOrdersItems(List<OrderItemResponse> items) {
        return items.stream()
                .map(this::convertToOrderItem)
                .collect(Collectors.toList());
    }

    private OrderItem convertToOrderItem(OrderItemResponse orderItemResponse){
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemResponse.getId());
        orderItem.setName(orderItemResponse.getName());
        orderItem.setDescription(orderItemResponse.getDescription());
        orderItem.setImageUrl(orderItemResponse.getImageUrl());
        orderItem.setBrand(orderItemResponse.getBrand());
        orderItem.setQuantity(orderItemResponse.getQuantity());
        orderItem.setPrice(orderItemResponse.getPrice());
        orderItem.setType(orderItemResponse.getType());
        return orderItem;
    }
}
