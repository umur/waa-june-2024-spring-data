package waa.springdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.springdata.entity.Address;
import waa.springdata.repository.AddressRepository;
import waa.springdata.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(int id,Address address){
        if(addressRepository.existsById(id)){
            return addressRepository.save(address);
        }
        return null;
    }
    @Override
    public void deleteById(int id) {
        addressRepository.deleteById(id);
    }
}
