package com.webApplicaton.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {

    @Id
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;
}
