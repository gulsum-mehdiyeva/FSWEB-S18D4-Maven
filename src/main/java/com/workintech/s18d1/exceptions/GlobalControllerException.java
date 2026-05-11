package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalControllerException {

    // Catch specific custom exceptions
    @ExceptionHandler(BurgerErrorException.class)
    public ResponseEntity<BurgerErrorResponse> handleResourceNotFound(BurgerErrorException ex) {
        BurgerErrorResponse error = new BurgerErrorResponse(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Catch-all for any other unhandled exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleGlobalException(Exception ex) {
        BurgerErrorResponse error = new BurgerErrorResponse("Unexpected error");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
