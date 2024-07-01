package com.project.lab2.controller;

import com.project.lab2.entity.Product;
import com.project.lab2.service.CategoryService;
import com.project.lab2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> getProducts() {
        return  productService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findByProductId(id);
        if (product.isEmpty()) {
            return Optional.empty();
        }
        return productService.findByProductId(id);
    }

    @PostMapping
    public Product  addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void  deleteProduct(@PathVariable Long id) {
            productService.delete(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(product, id);
    }

    @GetMapping("/price")
    public List<Product> getMinPrice(@RequestParam double price) {
        return productService.findAllByMinPrice(price);
    }

    @GetMapping("category-price")
    public List<Product> getCategoryCostLessThanPrice(@RequestParam Long categoryId, @RequestParam double price) {
        return productService.findAllByCategoryAndPriceLessThan(categoryId, price);

    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        return productService.searchByName(keyword);
    }

}
