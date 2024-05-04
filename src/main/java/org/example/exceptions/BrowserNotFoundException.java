package org.example.exceptions;

public class BrowserNotFoundException extends Exception{

    public BrowserNotFoundException(String message) {
        super(message);
    }
}