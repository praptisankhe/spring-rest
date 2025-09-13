package org.example.exception;

public class LibraryEmptyException extends RuntimeException{

    public LibraryEmptyException(String message)
    {
        super(message);
    }
}
