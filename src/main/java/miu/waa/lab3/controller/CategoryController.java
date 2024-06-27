package miu.waa.lab3.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.lab3.entity.Category;
import miu.waa.lab3.service.impl.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if(category == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        return ResponseEntity.ok().body(category);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot update category!");
        }
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}
