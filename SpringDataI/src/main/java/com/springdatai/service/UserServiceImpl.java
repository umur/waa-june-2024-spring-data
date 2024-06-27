package com.springdatai.service;

import com.springdatai.domain.Address;
import com.springdatai.domain.User;
import com.springdatai.repository.AddressRepository;
import com.springdatai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public User createUser(User user) {
        if (user == null) {
            throw new RuntimeException("User should not be null");
        }
        Address address = user.getAddress();
        if (address != null && address.getId() != 0) {
            // If address ID is provided, link existing address
            Optional<Address> existingAddress = addressRepository.findById(address.getId());
            if (existingAddress.isPresent()) {
                user.setAddress(existingAddress.get());
            } else {
                throw new RuntimeException("Address ID: " + address.getId() + " is not found");
            }
        } else if (address != null) {
            // If no address ID is provided, create new address
            address.setUser(user);
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User ID: " + id + " is not found");
        }
        return user;
    }

    @Override
    public User updateUserById(int id, User user) {
        Optional<User> userCheck = userRepository.findById(id);
        if (userCheck.isEmpty()) {
            throw new RuntimeException("User ID: " + id + " is not found");
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        Optional<User> userCheck = userRepository.findById(id);
        if (userCheck.isEmpty()) {
            throw new RuntimeException("User ID: " + id + " is not found");
        }
        userRepository.deleteById(id);
    }
}
