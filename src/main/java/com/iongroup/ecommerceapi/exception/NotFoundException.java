package com.iongroup.ecommerceapi.exception;

import com.iongroup.ecommerceapi.constants.ExceptionMessage;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Class<?> clazz) {
        super(clazz.getSimpleName() + ExceptionMessage.NOT_FOUND);
    }
}
