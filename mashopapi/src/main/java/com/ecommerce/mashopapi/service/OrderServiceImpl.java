package com.ecommerce.mashopapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.mashopapi.entity.Order;
import com.ecommerce.mashopapi.entity.OrderItem;
import com.ecommerce.mashopapi.exceptions.ProductNotFoundException;
import com.ecommerce.mashopapi.model.OrderItemResponse;
import com.ecommerce.mashopapi.model.OrderResponse;
import com.ecommerce.mashopapi.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderResponse> getAllOrders() {
       log.info("Listando as ordenes");
       List<Order> orderList = (List<Order>) orderRepository.findAll();

       //List<OrderResponse> orderResponses = orderList.stream().map(this::convertToOrderResponse).collect(Collectors.toList());
       List<OrderResponse> orderResponses = orderList.stream()
                .map(this::convertToOrderResponse)
                .collect(Collectors.toList());
       return orderResponses;
    }

    @Override
    public OrderResponse getOrderById(String id) {
        log.info("Mostrando Order por id");
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()){
            Order order = orderOptional.get();
            return convertToOrderResponse(order);
        }else{
            throw new ProductNotFoundException("Order id not found");
        } 
    }

    @Override
    public void deleteOrderById(String id) {
        log.info("Deletando Order");
        orderRepository.findById(id);
        log.info("Order fur deletado com sucesso");
    }

    @Override
    public OrderResponse createOrder(Order order) {
        log.info("Criando novo Order");
        Order newOrder = orderRepository.save(order);
        return convertToOrderResponse(newOrder);
    }
    

    private OrderResponse convertToOrderResponse(Order order){
        if(order == null){
            return null;
        }
        List<OrderItemResponse> itemResponses = order.getItems().stream()
                .map(this::convertToOrderItemResponse).collect(Collectors.toList());
        return OrderResponse.builder()
                .id(order.getId())
                .items(itemResponses)
                .build();
    }

    private OrderItemResponse convertToOrderItemResponse(OrderItem item){
        return OrderItemResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .imageUrl(item.getImageUrl())
                .price(item.getPrice())
                .brand(item.getBrand())
                .type(item.getType())
                .quantity(item.getQuantity())
                .build();
    }
}
