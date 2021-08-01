package org.vardhantrainings.exceptionhandling;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(String message) {
        super(message);
    }
}