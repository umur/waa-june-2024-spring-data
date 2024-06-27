package waa.springdata.service;

import waa.springdata.entity.Address;
import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address findById(int id);
    Address save(Address address);
    Address update(int id,Address address);
    void deleteById(int id);
}
