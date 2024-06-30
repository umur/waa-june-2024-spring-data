package com.springdatai.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
}
