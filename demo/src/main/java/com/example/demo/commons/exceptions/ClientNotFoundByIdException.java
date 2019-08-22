package com.example.demo.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientNotFoundByIdException extends RuntimeException{

    private long id;

    public ClientNotFoundByIdException(long id) {
        super(String.format(" not found by id: '%s'", id)); // i18n
        this.id = id;

    }

    public long getId() {
        return this.id;
    }

}