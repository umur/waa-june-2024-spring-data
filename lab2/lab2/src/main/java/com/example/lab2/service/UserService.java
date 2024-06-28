package com.example.lab2.service;

import com.example.lab2.dto.UserDTO;
import com.example.lab2.entity.User;

import java.util.List;

public interface UserService {
    UserDTO getById(Long id);
    User getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}
