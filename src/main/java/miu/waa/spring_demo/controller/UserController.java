package miu.waa.spring_demo.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Address;
import miu.waa.spring_demo.entity.User;
import miu.waa.spring_demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll() { return userService.getAll(); }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/{id}/addresses")
    public Address setUpAddress(@PathVariable int id, @RequestBody Address address) {
        return userService.setUpAddress(id, address);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteById(id);
    }
}
