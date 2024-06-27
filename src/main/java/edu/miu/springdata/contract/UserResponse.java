package edu.miu.springdata.contract;

import lombok.Data;

@Data
public class UserResponse {
    private Long            id;
    private String          email;
    private String          firstName;
    private String          lastName;
    private AddressResponse address;
}
