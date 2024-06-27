package com.example.demo.enity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

//    @Fetch(FetchMode.JOIN)
//    @JsonBackReference
    @JsonIgnoreProperties("reviews")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
