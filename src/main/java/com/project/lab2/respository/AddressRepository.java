package com.project.lab2.respository;

import com.project.lab2.entity.Address;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface AddressRepository extends ListCrudRepository<Address, Long> {
//    Optional<Address> findByAddressId(Long addressId);
}
