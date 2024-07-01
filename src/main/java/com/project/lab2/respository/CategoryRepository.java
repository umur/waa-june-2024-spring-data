package com.project.lab2.respository;

import com.project.lab2.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface CategoryRepository extends ListCrudRepository<Category, Long> {

}
