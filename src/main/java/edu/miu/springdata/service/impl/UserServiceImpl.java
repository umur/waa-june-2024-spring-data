package edu.miu.springdata.service.impl;

import edu.miu.springdata.contract.SaveUserRequest;
import edu.miu.springdata.contract.UpdatePasswordRequest;
import edu.miu.springdata.contract.UpdateUserRequest;
import edu.miu.springdata.contract.UserResponse;
import edu.miu.springdata.domain.User;
import edu.miu.springdata.exception.InvalidCurrentPasswordException;
import edu.miu.springdata.exception.ResourceAlreadyExistsException;
import edu.miu.springdata.exception.ResourceNotFoundException;
import edu.miu.springdata.repository.UserRepository;
import edu.miu.springdata.service.UserService;
import edu.miu.springdata.util.UserErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<UserResponse> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(user -> modelMapper.map(user, UserResponse.class));
    }

    @Override
    public UserResponse findById(Long userId) {
        return userRepository
                .findById(userId)
                .map(user -> modelMapper.map(user, UserResponse.class))
                .orElseThrow(() -> new ResourceNotFoundException(UserErrorMessages.userNotFound(userId)));
    }

    @Override
    public UserResponse addUser(SaveUserRequest saveUserRequest) {
        User existingUser = userRepository.findFirstByEmail(saveUserRequest.getEmail()).orElse(null);

        if (existingUser != null) {
            throw new ResourceAlreadyExistsException(UserErrorMessages.emailAlreadyExists(saveUserRequest.getEmail()));
        }

        User user = userRepository.save(modelMapper.map(saveUserRequest, User.class));

        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(Long userId, UpdateUserRequest updateUserRequest) {
        User existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser == null) {
            throw new ResourceNotFoundException(UserErrorMessages.userNotFound(userId));
        }
        modelMapper.map(updateUserRequest, existingUser);

        userRepository.save(existingUser);

        return modelMapper.map(existingUser, UserResponse.class);
    }

    @Override
    public void updatePassword(Long userId, UpdatePasswordRequest updatePasswordRequest) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(UserErrorMessages.userNotFound(userId)));

        if (!updatePasswordRequest.getCurrentPassword().equals(user.getPassword())) {
            throw new InvalidCurrentPasswordException(UserErrorMessages.currentPasswordIsIncorrect());
        }

        user.setPassword(updatePasswordRequest.getNewPassword());
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new ResourceNotFoundException(UserErrorMessages.userNotFound(userId));
        }

        userRepository.delete(user);
    }
}
