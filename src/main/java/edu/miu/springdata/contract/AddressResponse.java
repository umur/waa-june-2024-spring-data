package edu.miu.springdata.contract;

import lombok.Data;

@Data
public class AddressResponse {
    private Long   id;
    private String street;
    private String zip;
    private String city;

}
