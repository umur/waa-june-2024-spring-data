package cs545.lab.lab03.controller;

import cs545.lab.lab03.entity.Category;
import cs545.lab.lab03.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Optional<Category> category = categoryService.findById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category categoryDetails) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            Category updatedCategory = category.get();
            updatedCategory.setName(categoryDetails.getName());
            return ResponseEntity.ok(categoryService.save(updatedCategory));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
