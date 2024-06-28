package miu.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.User;
import miu.edu.springdata.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getUser(int id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
    @PostMapping
    public void addUser(User user) {
        userService.addUser(user);
    }
    @PutMapping
    public void updateUser(int id,User user) {
        userService.updateUser(id,user);
    }
    @DeleteMapping
    public void deleteUser(int id) {
        userService.removeUser(id);
    }
}
