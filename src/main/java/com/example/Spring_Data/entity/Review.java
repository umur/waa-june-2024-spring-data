package com.example.Spring_Data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;

    @ManyToOne()                   // WEAK ENTITY
    @JoinColumn(name = "user_id") // This is the foreign key in the review table that references the primary key in the user table
    private User user;

    @ManyToOne()
    @JoinColumn(name = "product_id") // WEAK ENTITY
    private Product product;         // This is the foreign key in the review table that references the primary key in the product table
}
