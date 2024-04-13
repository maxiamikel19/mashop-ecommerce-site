package com.ecommerce.mashopapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ecommerce.mashopapi.model.StandardResponse;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handlerProductNotFoundException(ProductNotFoundException e, WebRequest request){
        StandardResponse standardResp = new StandardResponse(HttpStatus.NOT_FOUND, "Product doesn't exist", e.getMessage());
        return new ResponseEntity<>(standardResp, HttpStatus.NOT_FOUND);
    }
}
