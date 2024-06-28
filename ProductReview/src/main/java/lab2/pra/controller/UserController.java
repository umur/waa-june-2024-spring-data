package lab2.pra.controller;

import lab2.pra.dto.UserDto;
import lab2.pra.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public UserDto update(@RequestBody UserDto user, @PathVariable Integer id) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.delete(id);
    }
}
