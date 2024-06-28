package lab2.pra.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewDto implements Serializable {
    private Long id;
    private String comment;
    private UserDto user;
    private ProductDto product;
}
