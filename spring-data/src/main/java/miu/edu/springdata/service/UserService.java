package miu.edu.springdata.service;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.User;
import miu.edu.springdata.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }
    public void removeUser(int id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            System.out.println("User not found");
            throw new IllegalArgumentException("User not found");
        }
        userRepository.delete(user);
    }
    public void updateUser(int id, User user){
       User user1 = userRepository.findById(id).orElse(null);
       if(user1 == null){
           System.out.println("User not found");
           throw new IllegalArgumentException("User not found");
       }
       user1.setFirstName(user.getFirstName());
       user1.setLastName(user.getLastName());
       user1.setEmail(user.getEmail());
       user1.setId(user.getId());
       user1.setReviews(user.getReviews());
       user1.setAddress(user.getAddress());
       user1.setPassword(user.getPassword());
       userRepository.save(user1);
    }
    public User getUser(int id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            System.out.println("User not found");
            throw new IllegalArgumentException("User not found");
        }
        return user;
    }
}
