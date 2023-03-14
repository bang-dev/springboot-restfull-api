package com.dev.springbootentitiesrestapi.exceptions;

public enum ValidationCode implements IErrorCode {
    INVALID(404),
    EXISTS(202),
    NOT_EXISTS(403),
    CREATED(200),
    UPDATED(205),
    UPDATED_FAIL(508),
    DELETED(208),
    FOUND(203),
    NOT_FOUND(402),
    CREATE_FAILED(506);

    private int number;

    ValidationCode(int number) {
        this.number = number;
    }

    @Override
    public int getCodeNumber(int number) {
        return number;
    }

}
