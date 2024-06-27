package edu.miu.cs545.lab3.lab3.controller;

import edu.miu.cs545.lab3.lab3.entity.User;
import edu.miu.cs545.lab3.lab3.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "User API")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public List<User> getAllReviews() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void save(User user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody User user) {
        userService.update(user);
    }
}
