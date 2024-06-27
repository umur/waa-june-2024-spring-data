package com.example.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

//Product with id, name, price and rating.
//A Product can belong to only one Category.
//A Product can have many Reviews.

@Entity
@Getter
@Setter
public class Product extends BaseEntity {
	private String name;
	private Double price;
	private Double rating;

	@Setter
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonBackReference
	Category category;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	List<Review> reviews;

}
