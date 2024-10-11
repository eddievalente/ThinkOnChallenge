package com.valente.api.controllers;

import com.valente.api.entities.User;
import com.valente.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName) {
        return new ResponseEntity<>(userService.getUser(userName), HttpStatus.OK);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<User> updateUser(@PathVariable String userName, @RequestBody User updatedUser) {
        return new ResponseEntity<>(userService.updateUser(userName, updatedUser), HttpStatus.OK);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userName) {
        userService.deleteUser(userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
