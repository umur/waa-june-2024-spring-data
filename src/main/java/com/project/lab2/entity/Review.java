package com.project.lab2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;
}
