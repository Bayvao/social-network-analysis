package com.social.network.analysis.exception;

/**
 * This class handles exception if a user is not found with its userId
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException (String message) {
        super(message);
    }
}
