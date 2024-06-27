package com.example.springdata.service_implement;

import com.example.springdata.model.Address;
import com.example.springdata.reponsitory.AddressRepository;
import com.example.springdata.service.AddressService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AddressServiceImplement implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, Address address) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()) {
            Address newAddress = addressOptional.get();
            newAddress.setCity(address.getCity());
            newAddress.setStreet(address.getStreet());
            newAddress.setZip(address.getZip());
            return addressRepository.save(newAddress);
        }

        return addressRepository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    public List<Address> findAll() {
        return (List<Address>)addressRepository.findAll();
    }
}
