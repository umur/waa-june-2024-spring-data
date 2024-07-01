package com.project.lab2.service.Impl;

import com.project.lab2.entity.Address;
import com.project.lab2.respository.AddressRepository;
import com.project.lab2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findByAddressId(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);

    }

    @Override
    public Address update(Address address, Long id) {
        Address oldAddress = addressRepository.findById(id).get();
        oldAddress.setCity(address.getCity());
        oldAddress.setZip(address.getZip());
        oldAddress.setStreet(address.getStreet());
        return addressRepository.save(address);

    }
}
