package com.social.network.analysis.service;

import com.social.network.analysis.entity.User;

import java.util.Set;

public interface FriendshipService {

    User createFriendship(String userId, String friendId);

    User removeFriendship(String userId, String friendId);

    Set<User> listFriends(String userId);

}
