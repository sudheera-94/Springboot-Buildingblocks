package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.dtos.UserDetailsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {

    // Simple method
    // URI - /helloWorld
    // Method - GET
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/userDetails")
    public UserDetailsDto getUserDetails() {
        return new UserDetailsDto("Sudheera", "Withanage", "Colombo");
    }
}
