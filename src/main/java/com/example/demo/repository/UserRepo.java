package com.example.demo.repository;

import com.example.demo.enity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User, Long> {
}
