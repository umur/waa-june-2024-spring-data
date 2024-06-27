package waa.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.springdata.entity.User;
import waa.springdata.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllCategory(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User updateById(@PathVariable int id,@RequestBody User user){
        return userService.update(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        userService.deleteById(id);
    }
}
