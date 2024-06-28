package edu.miu.springdata.contract;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String             email;
    private String             firstName;
    private String             lastName;
    private SaveAddressRequest address;
}
