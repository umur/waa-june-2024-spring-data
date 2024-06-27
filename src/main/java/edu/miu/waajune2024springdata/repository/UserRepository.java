package edu.miu.waajune2024springdata.repository;

import edu.miu.waajune2024springdata.entity.Address;
import edu.miu.waajune2024springdata.entity.User;
import org.springframework.data.repository.ListCrudRepository;

/**
 * @author kush
 */
public interface UserRepository extends ListCrudRepository<User,Long> {
}
