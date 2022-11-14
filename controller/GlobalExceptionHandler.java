package com.example.gas.controller;

import com.example.gas.exceptions.DuplicateResourceException;
import com.example.gas.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Object> exceptionHandler(DuplicateResourceException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(PageSizeException.class)
//    public ResponseEntity<Object> exceptionHandler(PageSizeException e){
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> exceptionHandler(ResourceNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
//    @ExceptionHandler(NoAccessException.class)
//    public ResponseEntity<Object> exceptionHandler(NoAccessException e){
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
//    }
//
//    @ExceptionHandler(InsufficientFundsException.class)
//    public ResponseEntity<Object> exceptionHandler(InsufficientFundsException e){
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//}
