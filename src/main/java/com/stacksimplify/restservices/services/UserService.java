package com.stacksimplify.restservices.services;

import com.stacksimplify.restservices.entities.UserEntity;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    // get user by Id
    public Optional<UserEntity> getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity;
    }

    // Get User by UserName
    public UserEntity getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    // Update User By Id
    public UserEntity updateUserById(Long id, UserEntity userEntity) {
        userEntity.setId(id);
        return userRepository.save(userEntity);
    }

    // Delete User By Id
    public void deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }

}
