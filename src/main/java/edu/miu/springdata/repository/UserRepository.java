package edu.miu.springdata.repository;

import edu.miu.springdata.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
