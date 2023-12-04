package com.unicap.aos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    
    public NotFoundException(Class clazz,Long id){
        super(String.format("%s de id %d não foi encontrado/a",clazz.getSimpleName(), id));
    }
}
