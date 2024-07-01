package com.project.lab2.service;

import com.project.lab2.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAll();
    Optional<Address> findByAddressId(Long id);
    Address save(Address address);
    void deleteById(Long id);
    Address update(Address address, Long id);
}
