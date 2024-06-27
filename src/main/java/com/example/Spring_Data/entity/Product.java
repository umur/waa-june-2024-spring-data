package com.example.Spring_Data.entity;

import com.example.Spring_Data.entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private int rating;

    @ManyToOne()                        // WEAK ENTITY
    @JoinColumn(name = "category_id")  // This is the foreign key in the product table that references the primary key in the category table
    private Category category;

    @OneToMany(mappedBy = "product")                  //STRONG ENTITY
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>(); // This is the field in the Review class that maps the relationship
}
