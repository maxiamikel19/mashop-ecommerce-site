package com.ecommerce.mashopapi.model;

import com.ecommerce.mashopapi.entity.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {
    
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private String imageUrl;
    private String brand;
    private String type;
    private Integer quantity;

    public OrderItemResponse(OrderItem obj) {
        this.brand = obj.getBrand();
        this.description = obj.getDescription();
        this.id = obj.getId();
        this.imageUrl = obj.getImageUrl();
        this.name = obj.getName();
        this.price = obj.getPrice();
        this.quantity = obj.getQuantity();
        this.type = obj.getType();
    }
}
