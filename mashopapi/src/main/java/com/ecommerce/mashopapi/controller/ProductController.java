package com.ecommerce.mashopapi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mashopapi.model.BrandResponse;
import com.ecommerce.mashopapi.model.ProductResponse;
import com.ecommerce.mashopapi.model.TypeResponse;
import com.ecommerce.mashopapi.service.BrandServiceImpl;
import com.ecommerce.mashopapi.service.ProductServiceImpl;
import com.ecommerce.mashopapi.service.TypeServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServiceImpl productService;
    private final TypeServiceImpl typeService;
    private final BrandServiceImpl brandService;

    public ProductController(ProductServiceImpl productService, TypeServiceImpl typeService,
            BrandServiceImpl brandService) {
        this.productService = productService;
        this.typeService = typeService;
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Integer productId){
        ProductResponse productResponse = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAllProducts(@PageableDefault(size = 10) Pageable pageable){
        
        Page<ProductResponse> productResponses = productService.getAllProducts(pageable);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @GetMapping("/brands")
    public ResponseEntity<List<BrandResponse>> getAllBrands(){
        List<BrandResponse> brandResponses = brandService.getAllBrands();
        return new ResponseEntity<>(brandResponses, HttpStatus.OK);
    }

    @GetMapping("/types")
    public ResponseEntity<List<TypeResponse>> getAllTypes(){
        List<TypeResponse> typeResponses = typeService.getAllTypes();
        return new ResponseEntity<>(typeResponses, HttpStatus.OK);
    }
}
