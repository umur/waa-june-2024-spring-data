package com.example.springdata.controller;

import com.example.springdata.entity.Category;
import com.example.springdata.entity.Product;
import com.example.springdata.service.CategoryService;
import com.example.springdata.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;

	@GetMapping
	public List<Product> getAll() {
		return productService.getAll();
	}

	@PostMapping("/{categoryId}")
	public ResponseEntity<?> createOne(@PathVariable String categoryId, @RequestBody Product product) throws Exception {
		Category category = categoryService.findById(categoryId).orElse(null);
		if (category == null) {
			return ResponseEntity.badRequest().body("Category not found!");
		}
		product.setCategory(category);
		Product item = productService.createOne(product);
		return ResponseEntity.ok().body(item);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateOne(@PathVariable String id, @RequestBody Product product) {
		Product item = productService.updateOne(id, product).orElse(null);
		if (item == null) {
			return ResponseEntity.badRequest().body("Product ID not found!");
		}
		return ResponseEntity.ok().body(item);
	}


	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable String id) {
		Product item = productService.deleteById(id).orElse(null);
		if (item == null) {
			return ResponseEntity.badRequest().body("Product ID is not found!");
		}
		return ResponseEntity.ok().body(item);
	}

	@GetMapping("/findProductsCostMoreThan/{minPrice}")
	public ResponseEntity<?> findProductsCostMoreThan(@PathVariable double minPrice) {
		return ResponseEntity.ok(productService.getProductsByPriceGreaterThan(minPrice));
	}
	@GetMapping("/findProductsContainKeyword/{keyword}")
	public ResponseEntity<?> findProductsContainKeyword(@PathVariable String keyword) {
		return ResponseEntity.ok(productService.getProductsContainKeyword(keyword));
	}
	@GetMapping("/findProductsInCategoryAndCostLessThan")
	public ResponseEntity<?> findProductsInCategoryAndCostLessThan(@RequestParam String category_id, @RequestParam Double max_price) {
		return ResponseEntity.ok(productService.getProductsInCategoryAndCostLessThan(category_id, max_price));
	}
}
