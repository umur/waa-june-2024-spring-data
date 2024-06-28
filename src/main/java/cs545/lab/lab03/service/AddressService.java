package cs545.lab.lab03.service;

import cs545.lab.lab03.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address addAddress(Address address);

    List<Address> getAllAddresses();

    Optional<Address> getAddressById(int id);

    void deleteAddress(int id);



}
