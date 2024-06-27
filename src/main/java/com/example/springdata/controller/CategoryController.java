package com.example.springdata.controller;

import com.example.springdata.entity.Category;
import com.example.springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> getAll() {
		return ResponseEntity.ok().body(categoryService.getAll());
	}

	@PostMapping
	public ResponseEntity<Category> createOne(@RequestBody Category cate) {
		Category item = categoryService.createOne(cate);
		return ResponseEntity.ok().body(item);
	}


	@PutMapping("/{id}")
	public ResponseEntity<?> updateOne(@RequestBody Category cate, @PathVariable String id) {
		Optional<Category> item = categoryService.updateOne(id, cate);
		if (item.isEmpty()) {
			return ResponseEntity.badRequest().body("Category id not found!");
		}
		return ResponseEntity.ok().body(item);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable String id) {
		Optional<Category> item = categoryService.deleteById(id);
		if (item.isEmpty()) {
			return ResponseEntity.badRequest().body("Category id not found!");
		}
		return ResponseEntity.ok().body(item);
	}
}
