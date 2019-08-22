package com.example.demo.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Set;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidParametersToUpdateClientException extends RuntimeException{

    private Set<String> params;

    public InvalidParametersToUpdateClientException(Set<String> params) {
        super(" bad params to update client: " + params);
        this.params = params;
    }

}