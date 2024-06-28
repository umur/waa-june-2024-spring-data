package com.example.lab2.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    private String comment;
    private UserDTO user;
    private ProductDTO product;
}
