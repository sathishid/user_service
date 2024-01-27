package com.addon.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorResponse<Object>> handleUserNotFoundException(UserNotFoundException ex) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<Testing>>>>>>>>>>>>>>>>");
        ApiErrorResponse<Object> response = new ApiErrorResponse<>(
                "error",
                ex.getMessage(),
                null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiErrorResponse<Object>> handleException(Exception ex) {
        ApiErrorResponse<Object> response = new ApiErrorResponse<>(
                "error",
                ex.getMessage(),
                null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
