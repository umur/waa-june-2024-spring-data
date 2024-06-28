package com.example.lab2.controller;

import com.example.lab2.dto.CategoryDTO;
import com.example.lab2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public List<CategoryDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO category){
        return service.save(category);
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@RequestBody CategoryDTO category,@PathVariable Long id){
        return service.update(id,category);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }
}
