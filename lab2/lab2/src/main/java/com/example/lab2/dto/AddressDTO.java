package com.example.lab2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private Long id;
    private String street;
    private String zip;
    private String city;
    private UserDTO user;
}
