package com.brunostaine.api.park.exceptions;

public class CodigoUniqueViolationException extends RuntimeException {
    public CodigoUniqueViolationException(String message) {
        super(message);
    }
}
