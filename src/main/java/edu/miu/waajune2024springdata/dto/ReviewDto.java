package edu.miu.waajune2024springdata.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kush
 */
@Data
public class ReviewDto implements Serializable {
    private Long id;
    private String comment;
    private UserDto user;
    private ProductDto product;
}
