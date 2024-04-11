package com.ecommerce.mashopapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.mashopapi.entity.Product;
import com.ecommerce.mashopapi.model.ProductResponse;
import com.ecommerce.mashopapi.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse getProductById(Integer id) {
       log.info("Mostrando um produto por seu Id: {}", id);

       Product product = productRepository.findById(id).orElseThrow( () -> new RuntimeException("O producto com o referente id:"+id+ " no existe."));
       ProductResponse productResponse = new ProductResponse(product);
       return productResponse;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        log.info("Listando todos os productos disponiveis");

        List<Product> productList = productRepository.findAll();
        List<ProductResponse> productResponses = productList.stream().map( p -> new ProductResponse(p)).collect(Collectors.toList());
        return productResponses;
    }

    
    
}
