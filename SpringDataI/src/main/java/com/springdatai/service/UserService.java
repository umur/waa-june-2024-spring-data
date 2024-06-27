package com.springdatai.service;

import com.springdatai.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    User updateUserById(int id, User user);

    void deleteUserById(int id);

}
