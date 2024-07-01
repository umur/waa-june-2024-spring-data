package com.project.lab2.service.Impl;

import com.project.lab2.entity.Address;
import com.project.lab2.entity.Category;
import com.project.lab2.entity.Review;
import com.project.lab2.entity.User;
import com.project.lab2.respository.AddressRepository;
import com.project.lab2.respository.UserRepository;
import com.project.lab2.service.UserService;
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
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUserId(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        Address address = addressRepository.findById(user.getAddress().getId()).orElse(null);
        user.setAddress(address);
        return userRepository.save(user);
    }

    @Override
    public User update(User user, Long id) {
        User oldUser = userRepository.findById(id).orElse(null);
        Address address = addressRepository.findById(user.getAddress().getId()).orElse(null);
        if (oldUser != null) {
            oldUser.setAddress(address);
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            return userRepository.save(user);
        } else {
            return null;
        }

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
