package com.example.resourcesmanager.exception;

public class NoPermissionException extends RuntimeException{
    public NoPermissionException(){
        super("You have no permission to watch this");
    }
}
