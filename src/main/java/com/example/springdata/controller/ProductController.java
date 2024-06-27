package com.example.springdata.controller;


import com.example.springdata.model.Product;
import com.example.springdata.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if(product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        productService.update(id, product);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-by-category-and-price")
    public ResponseEntity<List<Product>> getProductByCategoryNameAndPriceLessThan(@RequestParam String categoryName, @RequestParam Double price) {
        List<Product> products = productService.findAllByCategoryNameAndPriceLessThan(categoryName, price);
        if(products != null) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-price")
    public ResponseEntity<List<Product>> getProductByPriceGreaterThan(@RequestParam Double price) {
        List<Product> products = productService.findAllByPriceGreaterThan(price);
        if(products != null) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/get-by-name")
    public ResponseEntity<List<Product>> getProductByNameContaining(@RequestParam String keyword) {
        List<Product> products = productService.findAllByNameContaining(keyword);
        if(products != null) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }
}
