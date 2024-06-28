package com.example.lab2.service;

import com.example.lab2.dto.AddressDTO;
import com.example.lab2.entity.Address;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAll();
    AddressDTO getById(Long id);
    Address getAddressById(Long id);
    AddressDTO createAddress(AddressDTO address);
    AddressDTO updateAddress(Long id, AddressDTO addressDetails);
    void deleteAddress(Long id);
}

