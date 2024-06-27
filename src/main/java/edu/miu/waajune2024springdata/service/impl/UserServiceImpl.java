package edu.miu.waajune2024springdata.service.impl;

import edu.miu.waajune2024springdata.dto.UserDto;
import edu.miu.waajune2024springdata.entity.User;
import edu.miu.waajune2024springdata.mapper.DtoMapper;
import edu.miu.waajune2024springdata.repository.UserRepository;
import edu.miu.waajune2024springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author kush
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    @Override
    public List<UserDto> getAll() {
        return repo.findAll().stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public UserDto getById(Long id) {
        return DtoMapper.MAPPER.entityToDto(getUserById(id));
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOpt=repo.findById(id);
        if(userOpt.isEmpty()){
            throw new RuntimeException("No user Found");
        }
        return userOpt.get();
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user=DtoMapper.MAPPER.dtoToEntity(userDto);
        return DtoMapper.MAPPER.entityToDto(repo.save(user));
    }

    @Override
    public UserDto update(Long id, UserDto user) {
        Optional<User> userOpt=repo.findById(id);
        if(userOpt.isEmpty()){
            throw new RuntimeException("No user Found");
        }
        User savedUser=userOpt.get();
        savedUser.setEmail(user.getEmail());
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setPassword(user.getPassword());
        repo.save(savedUser);
        return DtoMapper.MAPPER.entityToDto(savedUser);
    }

    @Override
    public boolean delete(Long id) {
        Optional<User> userOpt=repo.findById(id);
        if(userOpt.isEmpty()){
            throw new RuntimeException("No user Found");
        }
        repo.delete(userOpt.get());
        return true;
    }
}
