package com.springdatai.service;

import com.springdatai.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(int id);

    Category updateCategoryById(int id, Category category);

    void deleteCategoryById(int id);

}
