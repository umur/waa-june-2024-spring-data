package com.webApplicaton.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    private String id;
    private String street;
    private String zip;
    private String city;

    @OneToOne
    @JsonBackReference
    private User user;
}
