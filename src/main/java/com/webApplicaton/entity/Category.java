package com.webApplicaton.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> products;
}
