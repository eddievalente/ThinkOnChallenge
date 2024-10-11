package com.valente.api.service;

import com.valente.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.valente.api.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method responsible for creating a new user
    public User createUser(User user) {
        if (userRepository.existsById(user.getUserName())) {
            throw new RuntimeException("User already exists.");
        }
        User newUser = userRepository.save(user);
        return newUser;
    }

    // Method responsible for returning all users
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    // Method responsible for returning the user by userName
    public User getUser(String userName) {
        User user = userRepository.findById(userName).orElseThrow(() -> new RuntimeException("User not found."));
        return user;
    }

    // Update a user
    public User updateUser(String userName, User user) {
        User updatedUser = userRepository.findById(userName).orElseThrow(() -> new RuntimeException("User not found."));
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(updatedUser);
        return updatedUser;
    }

    // Method responsible for deleting a user by userName
    public void deleteUser(String userName) {
        if (!userRepository.existsById(userName)) {
            throw new RuntimeException("User not found.");
        }
        userRepository.deleteById(userName);
    }
}
