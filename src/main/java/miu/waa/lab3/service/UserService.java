package miu.waa.lab3.service;

import miu.waa.lab3.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUserById(Long id);
}
