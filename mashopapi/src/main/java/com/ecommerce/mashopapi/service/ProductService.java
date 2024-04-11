package com.ecommerce.mashopapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecommerce.mashopapi.model.ProductResponse;

public interface ProductService {
    
    ProductResponse getProductById(Integer id);

    Page<ProductResponse> getAllProducts(Pageable pageable);
}
