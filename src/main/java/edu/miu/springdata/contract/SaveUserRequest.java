package edu.miu.springdata.contract;

import lombok.Data;

@Data
public class SaveUserRequest {
    private String             email;
    private String             firstName;
    private String             lastName;
    private String             password;
    private SaveAddressRequest address;
}
