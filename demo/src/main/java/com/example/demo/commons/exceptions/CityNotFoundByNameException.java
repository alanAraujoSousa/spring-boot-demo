package com.example.demo.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CityNotFoundByNameException extends RuntimeException{

    private String name;

    public CityNotFoundByNameException(String name) {
        super(String.format(" not found by name: '%s'", name)); // i18n
        this.name = name;

    }

    public String getName() {
        return this.name;
    }

}