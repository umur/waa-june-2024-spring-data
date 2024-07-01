package com.project.lab2.service.Impl;

import com.project.lab2.entity.Category;
import com.project.lab2.entity.Product;
import com.project.lab2.respository.CategoryRepository;
import com.project.lab2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findByCategoryId(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category, Long id) {
        Category oldCategory = categoryRepository.findById(id).orElse(null);
        if (oldCategory != null) {
            oldCategory.setName(category.getName());
            return categoryRepository.save(oldCategory);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
