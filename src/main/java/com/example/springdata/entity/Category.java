package com.example.springdata.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

//Category with id and name.
//A Category can have many Products.
@Entity
@Getter
@Setter
public class Category extends BaseEntity {
	private String name;

	@OneToMany(mappedBy = "category", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Product> products;
}
