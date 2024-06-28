package lab2.pra.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
