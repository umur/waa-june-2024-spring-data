package miu.waa.lab3.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.lab3.entity.Address;
import miu.waa.lab3.repository.AddressRepository;
import miu.waa.lab3.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        Address existAddress = addressRepository.findById(id).orElse(null);
        if(existAddress == null) return null;
        existAddress.setStreet(address.getStreet());
        existAddress.setCity(address.getCity());
        existAddress.setZip(address.getZip());
        return addressRepository.save(existAddress);
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }
}
