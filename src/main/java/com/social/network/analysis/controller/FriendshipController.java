package com.social.network.analysis.controller;

import com.social.network.analysis.entity.User;
import com.social.network.analysis.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/friendships")
public class FriendshipController {

    private final FriendshipService friendshipService;

    @Autowired
    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @PostMapping
    public ResponseEntity<User> createFriendship(@RequestParam("userId") String userId,
                                           @RequestParam("friendId") String friendId) {
        User user = friendshipService.createFriendship(userId, friendId);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<User> removeFriendship(@RequestParam("userId") String userId,
                                                 @RequestParam("friendId") String friendId) {
        User user = friendshipService.removeFriendship(userId, friendId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Set<User>> listFriends(@PathVariable("userId") String userId) {
        Set<User> friends = friendshipService.listFriends(userId);
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }
}
