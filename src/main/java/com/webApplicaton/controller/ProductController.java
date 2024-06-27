package com.webApplicaton.controller;

import com.webApplicaton.entity.Product;
import com.webApplicaton.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody Product product) {
        productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/priceGreaterThan")
    public List<Product> getProductsByMinPrice(@RequestParam Double minPrice) {
        return productService.getProductsByMinPrice(minPrice);
    }

    // Find all products in a specific category and cost less than maxPrice
    @GetMapping("/categoryAndPriceLessThan")
    public List<Product> getProductsByCategoryAndMaxPrice(
            @RequestParam String category, @RequestParam Double maxPrice) {
        return productService.getProductsByCategoryAndMaxPrice(category, maxPrice);
    }

    // Find all products that contain a keyword in the name
    @GetMapping("/nameContaining")
    public List<Product> getProductsByNameKeyword(@RequestParam String keyword) {
        return productService.getProductsByNameKeyword(keyword);
    }
}
