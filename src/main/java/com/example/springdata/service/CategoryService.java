package com.example.springdata.service;

import com.example.springdata.model.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category category);

    Category findById(Long id);

    Category save(Category category);

    Category update(Long id, Category category);

    void deleteById(Long id);

    List<Category> findAll();
}
