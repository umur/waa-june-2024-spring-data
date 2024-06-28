package com.example.lab2.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private double rating;
    private CategoryDTO category;
}
