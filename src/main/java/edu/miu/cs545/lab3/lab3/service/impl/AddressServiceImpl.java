package edu.miu.cs545.lab3.lab3.service.impl;

import edu.miu.cs545.lab3.lab3.entity.Address;
import edu.miu.cs545.lab3.lab3.repository.AddressRepo;
import edu.miu.cs545.lab3.lab3.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    @Override
    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepo.findById(id);
    }

    @Override
    public void save(Address address) {
        addressRepo.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepo.deleteById(id);
    }

    @Override
    public void update(Address address) {
        addressRepo.save(address);
    }
}
