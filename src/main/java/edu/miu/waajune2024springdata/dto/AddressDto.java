package edu.miu.waajune2024springdata.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kush
 */
@Data
public class AddressDto implements Serializable {
    private Long id;
    private String street;
    private String zip;
    private String city;
    private UserDto user;
}
