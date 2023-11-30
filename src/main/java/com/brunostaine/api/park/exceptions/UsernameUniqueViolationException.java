package com.brunostaine.api.park.exceptions;

public class UsernameUniqueViolationException extends RuntimeException {

    public UsernameUniqueViolationException(String message){
        super(message);
    }
}
