package com.waa.jpa.service.user;

import com.waa.jpa.dao.UserDAO;
import com.waa.jpa.entities.User;
import com.waa.jpa.service.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudServiceImpl<User, Long> {

    public UserService(UserDAO repository) {
        super(repository);
    }
}
