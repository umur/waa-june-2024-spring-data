package com.example.Spring_Data.service;

import com.example.Spring_Data.entity.User;
import com.example.Spring_Data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User userDetails) {
        User user = getUserById(id);
        user.setFname(userDetails.getFname());
        user.setLname(userDetails.getLname());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setAddress(userDetails.getAddress());
        user.setReviews(userDetails.getReviews());
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
