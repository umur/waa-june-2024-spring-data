package com.waa.jpa.entities.examples.oneToMany.uni;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class EmployeeUni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private int age;

    @OneToMany
    @JoinColumn(name = "id_employee")
    private List<PhoneUni> phones;
}
