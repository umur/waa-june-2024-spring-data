package com.example.springdata.service;

import com.example.springdata.entity.Address;
import com.example.springdata.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
	private final AddressRepository addressRepository;

	public List<Address> getAll() {
		return addressRepository.findAll();
	}

	public Address createOne(Address u) {
		return addressRepository.save(u);
	}

	public Address update(Address address) {
		return addressRepository.save(address);
	}
}
