package com.flypass.airbnb.general.exception;


import lombok.Data;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Data
public class AirBnbException extends Exception{


    private String message;
    private Integer errorCode;

    public AirBnbException(){}
    public AirBnbException(String message) {
        this.message = message;
    }

}
