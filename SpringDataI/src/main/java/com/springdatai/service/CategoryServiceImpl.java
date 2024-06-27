package com.springdatai.service;

import com.springdatai.domain.Category;
import com.springdatai.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        if (category == null) {
            throw new RuntimeException("Category should not be null");
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new RuntimeException("Category ID: " + id + " is not found");
        }
        return category;
    }

    @Override
    public Category updateCategoryById(int id, Category category) {
        Optional<Category> categoryCheck = categoryRepository.findById(id);
        if (categoryCheck.isEmpty()) {
            throw new RuntimeException("Category ID: " + id + " is not found");
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(int id) {
        Optional<Category> categoryCheck = categoryRepository.findById(id);
        if (categoryCheck.isEmpty()) {
            throw new RuntimeException("Category ID: " + id + " is not found");
        }
        categoryRepository.deleteById(id);
    }
}
