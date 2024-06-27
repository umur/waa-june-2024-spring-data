package waa.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.springdata.entity.User;
import waa.springdata.repository.AddressRepository;
import waa.springdata.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepo;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        if (user.getAddress() != null && user.getAddress().getId() > 0) {
            if (addressRepo.existsById(user.getAddress().getId())) {
                user.setAddress(addressRepo.findById(user.getAddress().getId()).orElse(user.getAddress()));
            } else {
                addressRepo.save(user.getAddress());
            }

        }
        return userRepository.save(user);
    }

    @Override
    public User update(int id,User user){
        if(userRepository.existsById(id)){
            return userRepository.save(user);
        }
        return null;
    }
    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
