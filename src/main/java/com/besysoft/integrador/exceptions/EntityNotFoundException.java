package com.besysoft.integrador.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception{

    public EntityNotFoundException() {}
    public EntityNotFoundException(String message) {
        super(message);
    }
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
