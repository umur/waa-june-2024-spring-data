package com.springdatai.controller;

import com.springdatai.domain.Category;
import com.springdatai.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    private List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    private Optional<Category> getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    private Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    private Category updateCategoryById(@PathVariable int id, @RequestBody Category category) {
        return categoryService.updateCategoryById(id, category);
    }

    @DeleteMapping("/{id}")
    private void deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
    }
}
