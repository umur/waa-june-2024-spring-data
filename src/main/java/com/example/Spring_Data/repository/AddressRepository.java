package com.example.Spring_Data.repository;

import com.example.Spring_Data.entity.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ListCrudRepository<Address, Integer> {
}
