package com.dev.springbootentitiesrestapi.exceptions;

public class CustomParameterConstraintException extends RuntimeException{
        public CustomParameterConstraintException(){
            super();
        }
    public CustomParameterConstraintException(String message) {
        super(message);
    }
}
