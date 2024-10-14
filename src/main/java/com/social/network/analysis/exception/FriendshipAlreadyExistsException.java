package com.social.network.analysis.exception;

/**
 * This class handles exception if friendship between two users already exists
 */
public class FriendshipAlreadyExistsException extends RuntimeException{

    public FriendshipAlreadyExistsException (String message) {
        super(message);
    }
}
