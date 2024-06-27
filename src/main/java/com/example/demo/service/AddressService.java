package com.example.demo.service;

import com.example.demo.enity.Address;
import com.example.demo.repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepo addressRepo;

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepo.findById(id).orElse(null);
    }

    public Address addAddress(Address address) {
        return addressRepo.save(address);
    }

    public Address updateAddress(Long id, Address address) {
        Address existingAddress = addressRepo.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setStreet(address.getStreet());
            existingAddress.setCity(address.getCity());
            existingAddress.setZip(address.getZip());
            existingAddress.setCity(address.getCity());
            return addressRepo.save(existingAddress);
        } else {
            return null;
        }
    }

    public void deleteAddress(Long id) {
        addressRepo.deleteById(id);
    }
}
