package com.example.resourcesmanager.exception;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException() {
        super("This field cannot be empty.");
    }
    public InvalidDataException(String message) {
        super(message);
    }
}
