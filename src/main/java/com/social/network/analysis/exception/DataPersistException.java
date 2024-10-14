package com.social.network.analysis.exception;

public class DataPersistException extends RuntimeException{

    public DataPersistException () {
        super("Error while persisting data");
    }
}
