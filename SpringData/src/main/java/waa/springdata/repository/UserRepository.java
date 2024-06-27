package waa.springdata.repository;

import org.springframework.data.repository.ListCrudRepository;
import waa.springdata.entity.User;

public interface UserRepository extends ListCrudRepository<User,Integer> {
}
