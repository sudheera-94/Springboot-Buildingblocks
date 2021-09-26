package com.stacksimplify.restservices.services;

import com.stacksimplify.restservices.entities.UserEntity;
import com.stacksimplify.restservices.exceptionHandling.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptionHandling.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Create user
    public UserEntity createUser(UserEntity userEntity) throws UserExistsException {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userEntity.getUserName());
        if (optionalUserEntity.isPresent()) {
            throw new UserExistsException("User already Exists");
        }
        return userRepository.save(userEntity);
    }


    // get user by Id
    public Optional<UserEntity> getUserById(Long id) throws UserNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findById(id);

        if (!userEntity.isPresent()) {
            throw new UserNotFoundException("User not found!");
        }
        return userEntity;
    }


    // Get User by UserName
    public Optional<UserEntity> getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


    // Update User By Id
    public UserEntity updateUserById(Long id, UserEntity userEntity) throws UserNotFoundException {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (!optionalUserEntity.isPresent()) {
            throw new UserNotFoundException("User not found!");
        }
        userEntity.setId(id);
        return userRepository.save(userEntity);
    }


    // Delete User By Id
    public void deleteUserById(Long id) throws ResponseStatusException {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found!");
        }
    }

}
