package com.dev.springbootentitiesrestapi.exceptions;

public class CustomDataNotFoundExceptionE extends RuntimeException{
    public CustomDataNotFoundExceptionE() {
        super();
    }

    public CustomDataNotFoundExceptionE(String message) {
        super(message);
    }

}
