package com.iongroup.ecommerceapi.exception;

import com.iongroup.ecommerceapi.constants.ExceptionMessage;

public class NotSavedException extends RuntimeException{
    public NotSavedException(Class<?> clazz) {
        super(clazz.getSimpleName() + ExceptionMessage.NOT_SAVED);
    }
}
