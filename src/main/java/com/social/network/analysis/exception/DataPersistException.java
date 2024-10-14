package com.social.network.analysis.exception;

/**
 * This exception class handles un-known exception while persisting data
 */
public class DataPersistException extends RuntimeException{

    public DataPersistException () {
        super("Error while persisting data");
    }
}
