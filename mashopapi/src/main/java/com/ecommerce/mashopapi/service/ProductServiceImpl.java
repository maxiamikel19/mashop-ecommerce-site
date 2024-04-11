package com.ecommerce.mashopapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
    public Page<ProductResponse> getAllProducts(Pageable pageable, Integer brandId, Integer typeId, String tectChain) {
        log.info("Listando todos os productos disponiveis");

        Specification<Product> spec = Specification.where(null);
        if(brandId != null){
            spec = spec.and((root, query, criteriaBuilder)->criteriaBuilder.equal(root.get("brand").get("id"), brandId));
        }

        if(typeId != null){
            spec = spec.and((root, query, criteriaBuilder)->criteriaBuilder.equal(root.get("type").get("id"), typeId));
        }

        if(tectChain != null && !tectChain.isEmpty()){
            spec = spec.and(((root, query, criteriaBuilder)->criteriaBuilder.like(root.get("name"), "%" + tectChain + "%")));
        }

        return productRepository.findAll(spec, pageable).map(this::convertToProductResponse);
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
