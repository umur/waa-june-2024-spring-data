package edu.miu.cs545.lab3.lab3.controller;

import edu.miu.cs545.lab3.lab3.entity.Category;
import edu.miu.cs545.lab3.lab3.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
@Tag(name = "Category", description = "Category API")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void save(Category category) {
        categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Category category) {
        categoryService.update(category);
    }
}
