package com.waa.jpa.controller;

import com.waa.jpa.entities.User;
import com.waa.jpa.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<User, Long> {

    public UserController(UserService service) {
        super(service);
    }
}
