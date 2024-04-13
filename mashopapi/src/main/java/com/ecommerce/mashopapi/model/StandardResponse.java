package com.ecommerce.mashopapi.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {
    private HttpStatus status;
    private String error;
    private String message;
}
