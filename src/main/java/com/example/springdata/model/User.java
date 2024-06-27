package com.example.springdata.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

//User can create many Reviews.
//User can have only one Address.
@Entity
@Setter
@Getter
public class User { //id, email, password, firstName, lastname
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

}
