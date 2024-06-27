package com.example.springdata.reponsitory;

import com.example.springdata.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User,Long> {
}
