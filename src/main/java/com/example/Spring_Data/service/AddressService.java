package com.example.Spring_Data.service;

import com.example.Spring_Data.entity.Address;
import com.example.Spring_Data.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(int id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(int id, Address addressDetails) {
        Address address = getAddressById(id);
        address.setStreet(addressDetails.getStreet());
        address.setZip(addressDetails.getZip());
        address.setCity(addressDetails.getCity());
        return addressRepository.save(address);
    }

    public void deleteAddress(int id) {
        Address address = getAddressById(id);
        addressRepository.delete(address);
    }
}
