package com.social.network.analysis.service.impl;

import com.social.network.analysis.dto.UserDTO;
import com.social.network.analysis.entity.User;
import com.social.network.analysis.exception.UserAlreadyExistException;
import com.social.network.analysis.repository.UserRepository;
import com.social.network.analysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User addUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getUserId());

        if (existingUser.isPresent()) {
            throw new UserAlreadyExistException("User already exists with userId: " + user.getUserId());
        }
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
    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }


}
