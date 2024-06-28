package edu.miu.springdata.contract;

import lombok.Data;

@Data
public class SaveAddressRequest {
    private String street;
    private String zip;
    private String city;

}
