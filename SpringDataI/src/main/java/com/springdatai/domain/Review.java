package com.springdatai.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue
    private int id;
    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

}
