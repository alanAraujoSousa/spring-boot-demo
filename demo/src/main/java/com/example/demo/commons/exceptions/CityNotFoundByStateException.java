package com.example.demo.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CityNotFoundByStateException extends RuntimeException{

    private String state;

    public CityNotFoundByStateException(String state) {
        super(String.format(" not found by state: '%s'", state)); // i18n
        this.state = state;

    }

    public String getState() {
        return this.state;
    }

}