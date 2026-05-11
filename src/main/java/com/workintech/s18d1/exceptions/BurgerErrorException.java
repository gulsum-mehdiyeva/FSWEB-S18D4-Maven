package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;

public class BurgerErrorException extends RuntimeException{
    private HttpStatus status;

    public BurgerErrorException(HttpStatus status) {
        this.status = status;
    }

    public BurgerErrorException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public BurgerErrorException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public BurgerErrorException(Throwable cause, HttpStatus status) {
        super(cause);
        this.status = status;
    }

    public BurgerErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
