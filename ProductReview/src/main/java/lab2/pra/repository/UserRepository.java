package lab2.pra.repository;

import lab2.pra.domain.Address;
import lab2.pra.domain.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, Integer> {
}
