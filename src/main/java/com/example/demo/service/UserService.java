package com.example.demo.service;

import com.example.demo.enity.Address;
import com.example.demo.enity.User;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.ReviewRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;
    private final AddressRepo addressRepo;
    private final ReviewRepo reviewRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User addUser(User user) {
        Address address = addressRepo.save(user.getAddress());
        user.setAddress(address);
        return userRepo.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepo.findById(id).orElse(null);
        Address address = addressRepo.save(user.getAddress());
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAddress(address);
            return userRepo.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
