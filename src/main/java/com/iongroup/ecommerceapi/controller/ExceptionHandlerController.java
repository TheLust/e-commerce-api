package com.iongroup.ecommerceapi.controller;

import com.iongroup.ecommerceapi.exception.NotFoundException;
import com.iongroup.ecommerceapi.exception.NotSavedException;
import com.iongroup.ecommerceapi.util.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler
    private ResponseEntity<ExceptionResponse> handleException(RuntimeException e) {
        return new ResponseEntity<>(
                new ExceptionResponse(e.getMessage(), new Date().getTime()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    private ResponseEntity<ExceptionResponse> handleException(NotFoundException e) {
        return new ResponseEntity<>(
                new ExceptionResponse(e.getMessage(), new Date().getTime()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler
    private ResponseEntity<ExceptionResponse> handleException(NotSavedException e) {
        return new ResponseEntity<>(
                new ExceptionResponse(e.getMessage(), new Date().getTime()),
                HttpStatus.CONFLICT
        );
    }
}
