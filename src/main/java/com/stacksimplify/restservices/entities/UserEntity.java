package com.stacksimplify.restservices.entities;

import lombok.Data;

import javax.persistence.*;

// Entity
@Entity
@Table(name = "user_table", schema = "test_schema")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String userName;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "ROLE", length = 50, nullable = false)
    private String role;

    @Column(name = "SSN", length = 50, nullable = false, unique = true)
    private String ssn;
}
