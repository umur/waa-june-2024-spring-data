package com.example.lab2.service;

import com.example.lab2.dto.CategoryDTO;
import com.example.lab2.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAll();

    CategoryDTO getById(Long id);

    Category getCategoryById(Long id);

    CategoryDTO save(CategoryDTO category);

    CategoryDTO update(Long id, CategoryDTO category);

    boolean delete(Long id);
}
