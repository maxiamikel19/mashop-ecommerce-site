package com.ecommerce.mashopapi.model;

import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.mashopapi.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String id;
    private List<OrderItemResponse> items;

   public OrderResponse(Order order){
        this.id = order.getId();
        this.items = order.getItems().stream().map(x -> new OrderItemResponse(x)).collect(Collectors.toList());
   }
}
