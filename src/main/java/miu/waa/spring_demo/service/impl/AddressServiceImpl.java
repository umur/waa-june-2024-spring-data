package miu.waa.spring_demo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Address;
import miu.waa.spring_demo.repository.AddressRepo;
import miu.waa.spring_demo.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    @Override
    public List<Address> getAll() {
        return addressRepo.findAll();
    }

    @Override
    public Address getById(Integer id) {
        return addressRepo.findById(id).orElse(null);
    }

    @Override
    public Address create(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public void deleteById(Integer id) {
        addressRepo.deleteById(id);
    }
}
