package com.springdatai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private String rating;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne
    private Category category;
}
