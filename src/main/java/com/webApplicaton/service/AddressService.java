package com.webApplicaton.service;

import com.webApplicaton.entity.Address;

import java.util.List;

public interface AddressService {

    public void save(Address address);
    public List<Address> findAll();
    public Address findById(Long id);
    public void delete(Long id);
    public void update(Long id,Address address);
}
