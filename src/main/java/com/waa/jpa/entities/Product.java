package com.waa.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private double price;

    private String rating;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne
    private Category category;
}
