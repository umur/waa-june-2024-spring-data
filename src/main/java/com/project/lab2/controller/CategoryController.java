package com.project.lab2.controller;

import com.project.lab2.entity.Category;
import com.project.lab2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
       return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.findByCategoryId(id);
    }

    @PostMapping
    public void  addCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void  deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.update(category, id);

    }
}
