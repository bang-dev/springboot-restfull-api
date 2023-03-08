package com.dev.springbootcloudinaryrestapi.exceptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}

