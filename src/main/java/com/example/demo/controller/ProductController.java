package com.example.demo.controller;

import com.example.demo.enity.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/cost-more-than")
    public List<Product> getProductsByCostMoreThan(@RequestParam double minPrice) {
        return productService.getProductsByPriceMoreThan(minPrice);
    }

    @GetMapping("/category-and-cost-less-than")
    public List<Product> getProductsByCategoryAndCostLessThan(@RequestParam String category, @RequestParam double minPrice) {
        return productService.getProductsByCategoryAndCostLessThan(category, minPrice);
    }

    @GetMapping("/search-product-by-keyword")
    public List<Product> searchProduct(@RequestParam String keyword) {
        return productService.searchProduct(keyword);
    }
}
