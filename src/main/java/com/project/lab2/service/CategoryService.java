package com.project.lab2.service;

import com.project.lab2.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findByCategoryId(Long id);

    Category save(Category category);

    Category update(Category category, Long id);

    void delete(Long id);

}
