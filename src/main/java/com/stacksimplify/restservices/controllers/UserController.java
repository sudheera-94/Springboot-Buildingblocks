package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.UserEntity;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Optional<UserEntity> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    // Get User by UserName
    @GetMapping("/users/byUserName/{user-name}")
    public UserEntity getUserByUserName(@PathVariable("user-name") String userName) {
        return userService.getUserByUserName(userName);
    }

    // Post user
    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    // Update User By Id
    @PutMapping("/users/{id}")
    public UserEntity updateUserById(@PathVariable("id") Long id,
                                     @RequestBody UserEntity userEntity) {
        return userService.updateUserById(id, userEntity);
    }

    // Delete User By Id
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }
}
