package com.project.lab2.controller;

import com.project.lab2.entity.Product;
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
    public void  addProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void  deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findByProductId(id);
        if (product.isPresent()) {
            productService.findByProductId(id);
        }
        return;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> prod = productService.findByProductId(id);
        if (prod.isPresent()) {
            return productService.update(product);
        }
        return null;
    }

}
