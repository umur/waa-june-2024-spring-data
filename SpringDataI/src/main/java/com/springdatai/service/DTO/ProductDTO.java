package com.springdatai.service.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private String rating;
    private List<ReviewDTO> reviews;
    private String categoryName;

    // Constructors
    public ProductDTO() {}

    public ProductDTO(int id, String name, double price, String rating, List<ReviewDTO> reviews, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.reviews = reviews;
        this.categoryName = categoryName;
    }
}
