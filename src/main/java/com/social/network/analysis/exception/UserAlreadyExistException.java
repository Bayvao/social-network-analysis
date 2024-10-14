package com.social.network.analysis.exception;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException (String message) {
        super(message);
    }
}
