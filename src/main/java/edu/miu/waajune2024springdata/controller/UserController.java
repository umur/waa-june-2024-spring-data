package edu.miu.waajune2024springdata.controller;

import edu.miu.waajune2024springdata.dto.UserDto;
import edu.miu.waajune2024springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kush
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public UserDto update(@RequestBody UserDto user,@PathVariable Long id){
        return userService.update(id,user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return userService.delete(id);
    }

}
