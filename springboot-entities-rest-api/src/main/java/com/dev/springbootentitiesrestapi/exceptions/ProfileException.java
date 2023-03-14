package com.dev.springbootentitiesrestapi.exceptions;

public class ProfileException extends RuntimeException{
    private ValidationCode validationCode;

    public ValidationCode getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(ValidationCode validationCode) {
        this.validationCode = validationCode;
    }

    public ProfileException(){
        super();
    }
    public ProfileException(String msg){
        super(msg);
    }

    public ProfileException(String message, ValidationCode code){
        super(message);
        this.validationCode = code;
    }



    public ProfileException(String message, Throwable cause,ValidationCode code){
        super(message,cause);
        this.validationCode = code;
    }

    public ProfileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace ,ValidationCode code){
        super(message,cause,enableSuppression,writableStackTrace);
        this.validationCode = code;
    }

}

