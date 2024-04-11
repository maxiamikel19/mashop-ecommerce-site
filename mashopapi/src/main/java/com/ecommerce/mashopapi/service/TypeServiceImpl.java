package com.ecommerce.mashopapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.mashopapi.entity.Type;
import com.ecommerce.mashopapi.model.TypeResponse;
import com.ecommerce.mashopapi.repository.TypeRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TypeServiceImpl implements TypeService{

    private final TypeRepository typeRepository;

    

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }



    @Override
    public List<TypeResponse> getAllTypes() {
        log.info("Listando todos os tipos:");
        
        List<Type> typeList =  typeRepository.findAll();

        List<TypeResponse> typeResponseList = typeList.stream().map(m -> new TypeResponse(m)).collect(Collectors.toList());
        return typeResponseList;
    }
    
}
