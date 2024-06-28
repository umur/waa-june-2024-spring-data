package lab2.pra.service.user;

import lab2.pra.adapter.DtoAdapter;
import lab2.pra.domain.User;
import lab2.pra.dto.UserDto;
import lab2.pra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(DtoAdapter.MAPPER::entityToDto)
                .toList();
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user=DtoAdapter.MAPPER.dtoToEntity(userDto);
        return DtoAdapter.MAPPER.entityToDto(userRepository.save(user));
    }

    @Override
    public UserDto update(Integer id, UserDto user) {
        User savedUser = findUserById(id);
        savedUser.setEmail(user.getEmail());
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setPassword(user.getPassword());
        userRepository.save(savedUser);
        return DtoAdapter.MAPPER.entityToDto(savedUser);
    }

    @Override
    public boolean delete(Integer id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return true;
    }

    @Override
    public UserDto findById(Integer id) {
        return DtoAdapter.MAPPER.entityToDto(findUserById(id));
    }

    @Override
    public User findUserById(Integer id) {
        Optional<User> userOpt=userRepository.findById(id);
        if(userOpt.isEmpty()){
            throw new RuntimeException("No user Found");
        }
        return userOpt.get();
    }
}
