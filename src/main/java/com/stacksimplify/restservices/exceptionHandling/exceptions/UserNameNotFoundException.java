package com.stacksimplify.restservices.exceptionHandling.exceptions;

public class UserNameNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    // Superclass constructor
    public UserNameNotFoundException(String message) {
        super(message);
    }
}
