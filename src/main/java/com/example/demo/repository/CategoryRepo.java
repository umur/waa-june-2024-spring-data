package com.example.demo.repository;

import com.example.demo.enity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepo extends ListCrudRepository<Category, Long>{
}
