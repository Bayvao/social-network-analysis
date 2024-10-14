package com.social.network.analysis.service.impl;

import com.social.network.analysis.entity.User;
import com.social.network.analysis.exception.FriendshipAlreadyExistsException;
import com.social.network.analysis.exception.UserNotFoundException;
import com.social.network.analysis.service.FriendshipService;
import com.social.network.analysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class FriendshipServiceImpl implements FriendshipService {

    private final UserService userService;

    @Autowired
    public FriendshipServiceImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param userId
     * @param friendId
     * @return
     */
    @Override
    public User createFriendship(String userId, String friendId) {
        User user = getOptionalUser(userId);
        User friend = getOptionalUser(friendId);

        Optional<User> matchingFriend = user.getFriends().stream().filter(f -> f.getUserId().equals(friend.getUserId())).findFirst();
        if (matchingFriend.isPresent()) {
           throw new FriendshipAlreadyExistsException("Friendship already exists between userId: " + userId + " and userId: " + friendId);
        }

        user.addFriend(friend);
        userService.addUser(user);
        userService.addUser(friend);

        return userService.getUserById(userId).orElse(null);

    }

    /**
     * @param userId
     * @param friendId
     * @return
     */
    @Override
    public User removeFriendship(String userId, String friendId) {
        User user = getOptionalUser(userId);
        User friend = getOptionalUser(userId);

        user.removeFriend(friend);
        userService.addUser(user);
        userService.addUser(friend);
        return userService.getUserById(userId).orElse(null);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public Set<User> listFriends(String userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(User::getFriends).orElse(Collections.emptySet());
    }

    private User getOptionalUser(String userId) {
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User does not exist with userId: " + userId);
        }
        return userOptional.get();
    }
}
