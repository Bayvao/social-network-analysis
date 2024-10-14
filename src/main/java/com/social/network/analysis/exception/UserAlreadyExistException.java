package com.social.network.analysis.exception;

/**
 * This class handles exception if a user already exists
 */
public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException (String message) {
        super(message);
    }
}
