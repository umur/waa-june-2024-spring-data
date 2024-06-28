package edu.miu.springdata.repository;


import edu.miu.springdata.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
