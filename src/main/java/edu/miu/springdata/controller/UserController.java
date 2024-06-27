package edu.miu.springdata.controller;

import edu.miu.springdata.contract.*;
import edu.miu.springdata.service.AddressService;
import edu.miu.springdata.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService    userService;
    private final AddressService addressService;

    public UserController(UserService userService, AddressService addressService) {
        this.userService    = userService;
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> getUserByUserId(
            @PathVariable("user-id") Long userId
                                                       ) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "201")})
    @PostMapping
    public ResponseEntity<UserResponse> addUser(
            @RequestBody SaveUserRequest userRequest
                                               ) {
        return new ResponseEntity<>(userService.addUser(userRequest), HttpStatus.CREATED);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Password is updated"),
                    @ApiResponse(responseCode = "404")
            }
    )
    @PutMapping("/{user-id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable("user-id") Long userId, @RequestBody UpdateUserRequest userRequest
                                                  ) {
        return ResponseEntity.ok(userService.updateUser(userId, userRequest));
    }


    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Password is updated"),
                    @ApiResponse(responseCode = "404")
            }
    )
    @PutMapping("/{user-id}/address")
    public ResponseEntity<AddressResponse> updateUserAddress(
            @PathVariable("user-id") Long userId, @RequestBody SaveAddressRequest addressRequest
                                                            ) {
        UserResponse user = userService.findById(userId);

        AddressResponse updateAddress = addressService.updateAddress(user.getAddress().getId(), addressRequest);

        return ResponseEntity.ok(updateAddress);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Password is updated"),
                    @ApiResponse(responseCode = "403", description = "Password doesn't match")
            }
    )
    @PutMapping("/{user-id}/password")
    public ResponseEntity<Void> updateUserPassword(
            @PathVariable("user-id") Long userId, @RequestBody UpdatePasswordRequest passwordRequest
                                                  ) {
        userService.updatePassword(userId, passwordRequest);

        return ResponseEntity.noContent().build();
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "204"), @ApiResponse(responseCode = "404")})
    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("user-id") Long userId) {
        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }
}
