package com.example.lab2.controller;

import com.example.lab2.dto.UserDTO;
import com.example.lab2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public UserDTO update(@RequestBody UserDTO user,@PathVariable Long id){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         userService.deleteUser(id);
    }
}
