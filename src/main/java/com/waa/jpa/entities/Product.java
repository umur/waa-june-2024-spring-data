package com.waa.jpa.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    @Column(unique = true)
    private double price;

    private String color;

    @JoinColumn(name = "productId")
    @OneToMany //(mappedBy = "product")
    private List<Review> reviews;
}
