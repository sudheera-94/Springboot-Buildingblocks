package com.stacksimplify.restservices.exceptionHandling;

import lombok.Data;

import java.util.Date;

// Create simple custom error details bean
@Data
public class CustomErrorDetails {

    private Date timestamp;
    private String message;
    private String errorDetails;

    public CustomErrorDetails(Date timestamp, String message, String errorDetails) {
        this.timestamp = timestamp;
        this.message = message;
        this.errorDetails = errorDetails;
    }
}
