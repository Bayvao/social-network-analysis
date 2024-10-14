package com.social.network.analysis.service.impl;

import com.social.network.analysis.entity.User;
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
        Optional<User> user = userService.getUserById(userId);
        Optional<User> friend = userService.getUserById(userId);

        if (user.isPresent() && friend.isPresent()) {
            user.get().addFriend(friend.get());

            userService.addUser(user.get());
            userService.addUser(friend.get());
        }

        return userService.getUserById(userId).orElse(null);

    }

    /**
     * @param userId
     * @param friendId
     * @return
     */
    @Override
    public User removeFriendship(String userId, String friendId) {
        Optional<User> user = userService.getUserById(userId);
        Optional<User> friend = userService.getUserById(userId);

        if (user.isPresent() && friend.isPresent()) {
            user.get().removeFriend(friend.get());

            userService.addUser(user.get());
            userService.addUser(friend.get());
        }

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
}
