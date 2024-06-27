package com.waa.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    private Long id;

    private String comment;

    private int rating;

//    @ManyToOne
//    private Product product;
}
