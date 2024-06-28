package com.waa.jpa.entities.examples.oneToMany.bi;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class EmployeeBi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private int age;

    @OneToMany(mappedBy = "employee")
    private List<PhoneBi> phones;
}
