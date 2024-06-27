package cs545.lab.lab03.service.impl;

import cs545.lab.lab03.entity.Address;
import cs545.lab.lab03.repo.AddressRepo;
import cs545.lab.lab03.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    @Override
    public Address addAddress(Address address) {
        return addressRepo.saveAndFlush(address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    @Override
    public Optional<Address> getAddressById(int id) {
        return addressRepo.findById(id);
    }

    @Override
    public void deleteAddress(int id) {
        addressRepo.deleteById(id);
    }


}
