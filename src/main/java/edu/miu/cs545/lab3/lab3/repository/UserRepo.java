package edu.miu.cs545.lab3.lab3.repository;

import edu.miu.cs545.lab3.lab3.entity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User, Long> {
}
