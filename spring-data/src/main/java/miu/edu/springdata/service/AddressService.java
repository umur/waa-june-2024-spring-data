package miu.edu.springdata.service;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.Address;
import miu.edu.springdata.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
    public void deleteAddress(int id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address == null) {
            throw new IllegalArgumentException("Address not found");
        }
        addressRepository.delete(address);
    }
    public Address updateAddress(int id, Address address) {
        Address Address = addressRepository.findById(id).orElse(null);
        if (Address == null) {
            throw new IllegalArgumentException("Address not found");
        }
        Address.setStreet(address.getStreet());
        Address.setCity(address.getCity());
        Address.setZip(address.getZip());

        return addressRepository.save(Address);

    }
    public Address findAddressById(int id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address == null) {
            throw new IllegalArgumentException("Address not found");
        }
        return address;
    }
    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

}
