package com.project.lab2.service;

import com.project.lab2.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findByUserId(Long id);
    User save(User user);
    User update(User user, Long id);
    void delete(Long id);

}
