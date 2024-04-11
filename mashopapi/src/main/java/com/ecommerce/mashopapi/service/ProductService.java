package com.ecommerce.mashopapi.service;

import java.util.List;

import com.ecommerce.mashopapi.model.ProductResponse;

public interface ProductService {
    
    ProductResponse getProductById(Integer id);

    List<ProductResponse> getAllProducts();
}
