package edu.miu.cs545.lab3.lab3.service.impl;

import edu.miu.cs545.lab3.lab3.entity.User;
import edu.miu.cs545.lab3.lab3.repository.UserRepo;
import edu.miu.cs545.lab3.lab3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(User user) {
        userRepo.save(user);
    }
}
