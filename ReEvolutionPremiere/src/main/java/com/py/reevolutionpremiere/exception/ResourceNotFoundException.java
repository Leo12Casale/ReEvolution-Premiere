package com.py.reevolutionpremiere.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
