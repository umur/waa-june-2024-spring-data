package com.example.lab2.service.impl;
import com.example.lab2.dto.UserDTO;
import com.example.lab2.entity.User;
import com.example.lab2.exception.ResourceNotFoundException;
import com.example.lab2.mapper.DtoMapper;
import com.example.lab2.repository.UserRepository;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public UserDTO getById(Long id) {
        return DtoMapper.MAPPER.entityToDto(getUserById(id));
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOpt=userRepository.findById(id);
        if(userOpt.isEmpty()){
            throw new RuntimeException("No user Found");
        }
        return userOpt.get();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user=DtoMapper.MAPPER.dtoToEntity(userDTO);
        return DtoMapper.MAPPER.entityToDto(userRepository.save(user));
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDetails) {
         User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
      // user.setAddress(userDetails.getAddress());
        return DtoMapper.MAPPER.entityToDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }
}

