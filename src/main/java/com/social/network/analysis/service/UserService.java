package com.social.network.analysis.service;

import com.social.network.analysis.dto.UserDTO;
import com.social.network.analysis.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

   User addUser(User user);

   void removeUser(String userId);

   List<User> listAllUsers();

   Optional<User> getUserById(String userId);
}
