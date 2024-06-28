package lab2.pra.controller;

import lab2.pra.dto.CategoryDto;
import lab2.pra.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable("id") Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public CategoryDto save(@RequestBody CategoryDto category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@RequestBody CategoryDto category, @PathVariable("id") Integer id) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return categoryService.delete(id);
    }
}
