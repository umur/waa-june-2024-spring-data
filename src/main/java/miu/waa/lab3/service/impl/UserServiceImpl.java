package miu.waa.lab3.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.lab3.entity.User;
import miu.waa.lab3.repository.UserRepository;
import miu.waa.lab3.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(@PathVariable Long id, User user) {
        User existUser = userRepository.findById(id).orElse(null);
        if(existUser == null) return null;
        existUser.setEmail(user.getEmail());
        existUser.setPassword(user.getPassword());
        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setAddress(user.getAddress());
        return userRepository.save(existUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
