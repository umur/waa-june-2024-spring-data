package miu.waa.spring_demo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Address;
import miu.waa.spring_demo.entity.User;
import miu.waa.spring_demo.repository.UserRepo;
import miu.waa.spring_demo.service.AddressService;
import miu.waa.spring_demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final AddressService addressService;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public Address setUpAddress(int userId, Address address) {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) throw new RuntimeException("Invalid user!");
        address.setUser(user);
        return addressService.create(address);
    }
}
