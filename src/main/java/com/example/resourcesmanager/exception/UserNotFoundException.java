package com.example.resourcesmanager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User doesn't exist: " + username);
    }
}