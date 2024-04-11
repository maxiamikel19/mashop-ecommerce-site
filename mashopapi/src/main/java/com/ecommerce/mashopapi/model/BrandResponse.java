package com.ecommerce.mashopapi.model;

import com.ecommerce.mashopapi.entity.Brand;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponse {
    
    private Integer id;
    private String name;

    public BrandResponse(Brand brand){
        this.id = brand.getId();
        this.name = brand.getName();
    }
    
}
