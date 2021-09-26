package com.stacksimplify.restservices.exceptionHandling;

import com.stacksimplify.restservices.exceptionHandling.exceptions.UserNameNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;

//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // MethodArgumentNotValidException
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "From MethodArgumentNotValid Exception in GEH", ex.getLocalizedMessage());

        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);

    }

    // HttpRequestMethodNotSupported
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status,
                                                                         WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "From HttpRequestMethodNotSupported Exception in GEH", ex.getLocalizedMessage());

        return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // UsernameNotFoundException
    @ExceptionHandler(UserNameNotFoundException.class)
    public final ResponseEntity<Object> handleUsernameNotFoundException(UserNameNotFoundException ex,
                                                                        WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
    }

    // ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
                                                                           WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
    }

}
