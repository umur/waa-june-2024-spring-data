package com.waa.jpa.entities.examples.manyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @ManyToMany
    private List<Book> books;
}
