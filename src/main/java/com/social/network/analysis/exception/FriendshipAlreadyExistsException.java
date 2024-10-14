package com.social.network.analysis.exception;

public class FriendshipAlreadyExistsException extends RuntimeException{

    public FriendshipAlreadyExistsException (String message) {
        super(message);
    }
}
