package com.example.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

//Review with id, comment.
//A Review can only belong to one User and Product.
@Entity
@Getter
@Setter
public class Review extends BaseEntity {
	private String comment;

	@Setter
	@ManyToOne
	@JsonIgnoreProperties("reviews")
	private User user;

	@Setter
	@ManyToOne
	@JsonIgnore
	private Product product;
}
