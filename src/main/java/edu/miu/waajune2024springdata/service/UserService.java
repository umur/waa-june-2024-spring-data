package edu.miu.waajune2024springdata.service;

import edu.miu.waajune2024springdata.dto.UserDto;
import edu.miu.waajune2024springdata.entity.User;

import java.util.List;

/**
 * @author kush
 */
public interface UserService {
    List<UserDto> getAll();

    UserDto getById(Long id);

    User getUserById(Long id);

    UserDto save(UserDto user);

    UserDto update(Long id, UserDto user);

    boolean delete(Long id);
}
