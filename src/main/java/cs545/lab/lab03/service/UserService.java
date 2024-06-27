package cs545.lab.lab03.service;

import cs545.lab.lab03.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findById(int id);

    List<User> findAll();

    void deleteById(int id);

}
