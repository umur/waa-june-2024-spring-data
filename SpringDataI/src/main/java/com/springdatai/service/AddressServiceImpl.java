package com.springdatai.service;

import com.springdatai.domain.Address;
import com.springdatai.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address createAddress(Address address) {
        if(address == null){
            throw new RuntimeException("Address should not be null");
        }
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(int id) {
        Optional<Address> address = addressRepository.findById(id);
        if(address.isEmpty()){
            throw new RuntimeException("Address ID: " + id + "is not found");
        }
        return addressRepository.findById(id);
    }

    @Override
    public Address updateAddressById(int id, Address address) {
        Optional<Address> addressCheck = addressRepository.findById(id);
        if(addressCheck.isEmpty()){
            throw new RuntimeException("Address ID: " + id + "is not found");
        }
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddressById(int id) {
        Optional<Address> addressCheck = addressRepository.findById(id);
        if(addressCheck.isEmpty()){
            throw new RuntimeException("Address ID: " + id + "is not found");
        }
        addressRepository.deleteById(id);
    }
}
