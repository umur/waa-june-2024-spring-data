package com.waa.jpa.dao;

import com.waa.jpa.entities.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends ListCrudRepository<User, Long> {
}
