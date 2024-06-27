package com.example.springdata.service;

import com.example.springdata.model.Address;

import java.util.List;

public interface AddressService {
    Address create(Address address);

    Address save(Address address);

    Address update(Long id, Address address);

    void deleteById(Long id);

    List<Address> findAll();
}
