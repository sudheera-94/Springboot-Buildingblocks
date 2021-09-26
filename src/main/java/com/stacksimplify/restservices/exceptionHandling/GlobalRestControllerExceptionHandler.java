package com.stacksimplify.restservices.exceptionHandling;

import com.stacksimplify.restservices.exceptionHandling.exceptions.UserNameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalRestControllerExceptionHandler {

    @ExceptionHandler(UserNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails usernameNotFound(UserNameNotFoundException ex) {
        return new CustomErrorDetails(new Date(), "From @RestControllerAdvice NotFound", ex.getMessage());
    }
}
