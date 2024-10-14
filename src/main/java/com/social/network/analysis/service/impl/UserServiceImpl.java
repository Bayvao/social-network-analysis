package com.social.network.analysis.service.impl;

import com.social.network.analysis.dto.UserDTO;
import com.social.network.analysis.entity.User;
import com.social.network.analysis.repository.UserRepository;
import com.social.network.analysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param userDTO
     * @return the newly created user
     */
    @Override
    public User addUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.userId().toLowerCase());
        user.setName(user.getName());
        user.setEmail(userDTO.email());

        return userRepository.save(user);
    }

    /**
     * @param userId
     * deletes a user by its id.
     */
    @Override
    public void removeUser(String userId) {
        userRepository.deleteById(userId);
    }

    /**
     * @return all the users
     */
    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    /**
     * @param userId
     * @return a user or else it throws an exception
     */
    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not present with userId: " + userId));
    }


}
