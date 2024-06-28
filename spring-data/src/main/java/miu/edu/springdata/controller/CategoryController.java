package miu.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.Category;
import miu.edu.springdata.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorys")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public void saveCategory(Category category) {
        categoryService.addCategory(category);
    }
    @GetMapping
    public ResponseEntity<?> getCategory(int id){
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
    @PutMapping
    public ResponseEntity<?> updateCategory(int id,Category category){
        return ResponseEntity.ok(categoryService.updateCategory(id,category));
    }
    @DeleteMapping
    public void deleteCategory(int id){
        categoryService.removeCategory(id);
    }

}
