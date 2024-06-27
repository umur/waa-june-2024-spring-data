package miu.waa.lab3.service;

import miu.waa.lab3.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    List<Address> getAllAddresses();
    Address getAddressById(Long id);
    Address createAddress(Address address);
    Address updateAddress(Long id, Address address);
    void deleteAddressById(Long id);
}
