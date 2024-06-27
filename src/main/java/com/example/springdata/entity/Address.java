package com.example.springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;

//Address with id, street, zip and city.
//An Address can belong to only one User.
@Getter
@Entity
public class Address extends BaseEntity {
	private String street, zip, city;
}
