package miu.waa.spring_demo.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Category;
import miu.waa.spring_demo.entity.Product;
import miu.waa.spring_demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAll() { return categoryService.getAll(); }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @PostMapping("/{id}/products")
    public Product createProduct(@PathVariable int id, @RequestBody Product product) {
        return categoryService.createProduct(id, product);
    }

    @PutMapping
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.deleteById(id);
    }
}
