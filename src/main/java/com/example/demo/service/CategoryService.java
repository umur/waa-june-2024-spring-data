package com.example.demo.service;

import com.example.demo.enity.Category;
import com.example.demo.enity.Product;
import com.example.demo.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public Category addCategory(Category category) {
        System.out.println(category.toString());
        return categoryRepo.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepo.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            return categoryRepo.save(existingCategory);
        } else {
            return null;
        }
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
