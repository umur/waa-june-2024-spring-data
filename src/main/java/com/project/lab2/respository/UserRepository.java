package com.project.lab2.respository;

import com.project.lab2.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {
//    Optional<User> findByUserId(Long studentId);
}
