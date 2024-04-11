package com.ecommerce.mashopapi.model;

import com.ecommerce.mashopapi.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private String pictureUrl;
    private String brand;
    private String type;

    public ProductResponse(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.brand = product.getBrand().getName();
        this.pictureUrl = product.getPictureUrl();
        this.price = product.getPrice();
        this.type = product.getType().getName();
    }
}
