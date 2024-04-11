package com.ecommerce.mashopapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ProductResponse> getAllProducts(Pageable pageable) {
        log.info("Listando todos os productos disponiveis");

        Page<Product> productPage = productRepository.findAll(pageable);
        Page<ProductResponse> productResponses = productPage.map(this::convertToProductResponse);
        return productResponses;
    }

    private ProductResponse convertToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .brand(product.getBrand().getName())
                .type(product.getType().getName())
                .pictureUrl(product.getPictureUrl())
                .build();
    }
    
    
}
