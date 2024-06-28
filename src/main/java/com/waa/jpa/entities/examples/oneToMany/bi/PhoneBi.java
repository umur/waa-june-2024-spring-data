package com.waa.jpa.entities.examples.oneToMany.bi;

import jakarta.persistence.*;

@Entity
public class PhoneBi {

    @Id
    @GeneratedValue
    private Long id;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn // Optional
    private EmployeeBi employee;
}
