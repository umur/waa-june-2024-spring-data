package miu.waa.spring_demo.repository;

import miu.waa.spring_demo.entity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User, Integer> {
}
