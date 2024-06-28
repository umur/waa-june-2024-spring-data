package com.project.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    private int rating;

    @ManyToOne
    @JoinColumn(name="category-id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
