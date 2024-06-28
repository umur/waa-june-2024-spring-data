package edu.miu.springdata.service;

import edu.miu.springdata.contract.SaveUserRequest;
import edu.miu.springdata.contract.UpdatePasswordRequest;
import edu.miu.springdata.contract.UpdateUserRequest;
import edu.miu.springdata.contract.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserResponse> findAll(Pageable pageable);

    UserResponse findById(Long userId);

    UserResponse addUser(SaveUserRequest saveUserRequest);

    UserResponse updateUser(Long userId, UpdateUserRequest saveUserRequest);

    void updatePassword(Long userId, UpdatePasswordRequest updatePasswordRequest);

    void deleteUser(Long userId);
}
