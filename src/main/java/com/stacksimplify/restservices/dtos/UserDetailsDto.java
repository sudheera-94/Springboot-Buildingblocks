package com.stacksimplify.restservices.dtos;

import lombok.Data;

@Data
public class UserDetailsDto {

    private String firstName;
    private String lastName;
    private String city;

    public UserDetailsDto(String firstName, String lastName, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }
}
