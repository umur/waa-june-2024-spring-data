package com.example.springdata.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
}
