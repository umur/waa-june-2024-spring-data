package com.springdatai.service;

import com.springdatai.domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address createAddress(Address address);

    List<Address> getAllAddress();

    Optional<Address> getAddressById(int id);

    Address updateAddressById(int id, Address address);

    void deleteAddressById(int id);

}
