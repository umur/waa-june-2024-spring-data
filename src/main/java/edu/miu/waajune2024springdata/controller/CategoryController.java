package edu.miu.waajune2024springdata.controller;

import edu.miu.waajune2024springdata.dto.CategoryDto;
import edu.miu.waajune2024springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kush
 */
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public List<CategoryDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public CategoryDto save(@RequestBody CategoryDto category){
        return service.save(category);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@RequestBody CategoryDto category,@PathVariable Long id){
        return service.update(id,category);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }
}
