package lab2.pra.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private Long id;
    private String street;
    private String zip;
    private String city;
    private UserDto user;
}
