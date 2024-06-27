package com.example.Spring_Data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;

    @OneToOne()                      // WEAK ENTITY
    @JoinColumn(name = "address_id") // This is the foreign key in the user table that references the primary key in the address table
    private Address address;

    @OneToMany(mappedBy = "user") // This is the field in the Review class that maps the relationship
    @JsonIgnore
    private List<Review> reviews; // STRONG ENTITY
}
