package com.ecommerce.mashopapi.entity;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RedisHash("OrderItem")
public class OrderItem {
    
    @Id
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private String imageUrl;
    private String brand;
    private String type;
    private Integer quantity;
}
