package com.example.springdata.service;

import com.example.springdata.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User findById(Long id);

    User save(User user);

    User update(Long id, User user);

    void deleteById(Long id);

    List<User> findAll();
}
