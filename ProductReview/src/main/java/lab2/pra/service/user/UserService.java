package lab2.pra.service.user;

import lab2.pra.domain.User;
import lab2.pra.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto save(UserDto user);

    UserDto update(Integer id, UserDto user);

    boolean delete(Integer id);

    UserDto findById(Integer id);

    User findUserById(Integer id);
}
