package com.webApplicaton.service;
import com.webApplicaton.entity.User;

import java.util.List;

public interface UserService {

    public void save(User user);
    public List<User> findAll();
    public User findById(Long id);
    public void delete(Long id);
    public void update(Long id, User user);
}
