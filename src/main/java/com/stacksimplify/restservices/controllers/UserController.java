package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.UserEntity;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // get all users method
    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by id
    @GetMapping("/users/{id}")
    public Optional<UserEntity> getUserById(@PathVariable("id") Long id) throws ResponseStatusException {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    // Get User by UserName
    @GetMapping("/users/byUserName/{user-name}")
    public Optional<UserEntity> getUserByUserName(@PathVariable("user-name") String userName) {
        return userService.getUserByUserName(userName);
    }

    // Post user
    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody UserEntity userEntity, UriComponentsBuilder builder)
            throws ResponseStatusException {
        try {
            userService.createUser(userEntity);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(userEntity.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (UserExistsException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    // Update User By Id
    @PutMapping("/users/{id}")
    public UserEntity updateUserById(@PathVariable("id") Long id,
                                     @RequestBody UserEntity userEntity) throws ResponseStatusException {
        try {
            return userService.updateUserById(id, userEntity);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    // Delete User By Id
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }
}
