package com.example.resourcesmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidDataAdvice {
//    @ResponseBody
//    @ExceptionHandler(InvalidDataException.class)
//    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//    public String InvalidDataHandler(InvalidDataException ex){
//        return ex.getMessage();
//    }

    @ResponseBody
    @ExceptionHandler(InvalidDataException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String InvalidDataHandler2(InvalidDataException ex){
        return ex.getMessage();
    }
}
