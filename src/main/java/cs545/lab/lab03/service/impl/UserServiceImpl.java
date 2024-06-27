package cs545.lab.lab03.service.impl;

import cs545.lab.lab03.entity.User;
import cs545.lab.lab03.repo.UserRepo;
import cs545.lab.lab03.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }


    @Override
    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }
}
