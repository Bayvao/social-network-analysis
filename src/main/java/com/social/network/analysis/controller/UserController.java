package com.social.network.analysis.controller;

import com.social.network.analysis.dto.UserDTO;
import com.social.network.analysis.entity.User;
import com.social.network.analysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * creates a new user with the given details
     */
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.userId());
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        User savedUser = userService.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * @param userId
     * deletes a user by its id
     */
    @PostMapping("/{id}")
    public ResponseEntity<HttpStatusCode> removeUser(@PathVariable("id") String userId) {
        userService.removeUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * returns list of all users
     */
    @GetMapping
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.listAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
