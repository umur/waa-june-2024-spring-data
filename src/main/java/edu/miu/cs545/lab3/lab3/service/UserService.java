package edu.miu.cs545.lab3.lab3.service;

import edu.miu.cs545.lab3.lab3.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    void save(User user);

    void delete(Long id);

    void update(User user);
}
