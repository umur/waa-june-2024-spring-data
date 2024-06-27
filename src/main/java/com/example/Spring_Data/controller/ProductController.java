package com.example.Spring_Data.controller;

import com.example.Spring_Data.entity.Product;
import com.example.Spring_Data.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/price")
    public ResponseEntity<List<Product>> findAllByPriceGreaterThan(@RequestParam int price) {
        return ResponseEntity.ok(productService.findAllByPriceGreaterThan(price));
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> findAllByCategory_IdAndPriceLessThan(@RequestParam int categoryId, @RequestParam int price) {
        return ResponseEntity.ok(productService.findAllByCategory_IdAndPriceLessThan(categoryId, price));
    }

    @GetMapping("/name")
    public ResponseEntity<List<Product>> findAllByNameContains(@RequestParam String name) {
        return ResponseEntity.ok(productService.findAllByNameContains(name));
    }
}
