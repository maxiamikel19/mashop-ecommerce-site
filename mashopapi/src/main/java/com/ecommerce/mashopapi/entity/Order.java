package com.ecommerce.mashopapi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.redis.core.RedisHash;

import com.ecommerce.mashopapi.model.OrderItemResponse;
import com.ecommerce.mashopapi.model.OrderResponse;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RedisHash("Order")
public class Order {
    

    @Id
    private String id;
    private List<OrderItem> items = new ArrayList<>();
    public Order(String id) {
        this.id = id;
    }

    public Order (OrderResponse obj){
        this.id = obj.getId();
        //this.items = obj.getItems().stream().map(x -> new OrderResponse(x)).collect(Collectors.toList());
    }
}
