package waa.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.springdata.entity.Category;
import waa.springdata.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id){
        return categoryService.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category updateById(@PathVariable int id,@RequestBody Category category){
        return categoryService.update(id,category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        categoryService.deleteById(id);
    }
}
