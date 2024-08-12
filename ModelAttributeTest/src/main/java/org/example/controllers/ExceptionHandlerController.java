package org.example.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullPointerException(){
        return "null-pointer-exception";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleAnyException(){
        return "exception";
    }
}
