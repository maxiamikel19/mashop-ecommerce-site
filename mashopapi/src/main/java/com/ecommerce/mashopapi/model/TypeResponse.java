package com.ecommerce.mashopapi.model;

import com.ecommerce.mashopapi.entity.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeResponse {
    
    private Integer id;
    private String name;

    public TypeResponse (Type type){
        this.id = type.getId();
        this.name = type.getName();
    }
}
