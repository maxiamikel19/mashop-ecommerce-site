package com.ecommerce.mashopapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.mashopapi.entity.Brand;
import com.ecommerce.mashopapi.model.BrandResponse;
import com.ecommerce.mashopapi.repository.BrandRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }



    @Override
    public List<BrandResponse> getAllBrands() {
        log.info("Lista dos modelos");

        List<Brand> brandList = brandRepository.findAll();

        List<BrandResponse> brandResponseList = brandList.stream().map( b -> new BrandResponse(b)).collect(Collectors.toList());
        return brandResponseList;
    }

    
    
}
