package com.project.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Address {
    @Id
    private Long id;
    private String street;
    private String city;
    private String zip;

    @OneToOne
    @JoinColumn(name="user-id")
    private User user;

}
