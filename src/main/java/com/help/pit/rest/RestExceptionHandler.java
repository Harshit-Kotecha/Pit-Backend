package com.help.pit.rest;

import com.help.pit.entity.ResourceError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ResourceError> handleException(ResourceNotFoundException exception) {
        ResourceError error = new ResourceError();

        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ResourceError> handleException(Exception exception) {
        ResourceError error = new ResourceError();

        error.setMessage(exception.getLocalizedMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
