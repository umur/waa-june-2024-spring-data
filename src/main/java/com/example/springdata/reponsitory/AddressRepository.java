package com.example.springdata.reponsitory;

import com.example.springdata.model.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ListCrudRepository<Address,Long> {
}