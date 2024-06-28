package com.example.lab2.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class UserDTO implements Serializable {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    //private Long addressId;
}
