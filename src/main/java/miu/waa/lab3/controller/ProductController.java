package miu.waa.lab3.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.lab3.entity.Product;
import miu.waa.lab3.service.impl.ProductServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImpl productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if(product == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot update product!");
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping(params = "name")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping(params = "min_price")
    public List<Product> getProductsByMinPrice(@RequestParam("min_price") Double minPrice) {
        return productService.getProductsByMinPrice(minPrice);
    }

    @GetMapping(params = {"category", "max_price"})
    public List<Product> getProductsByCategoryNameAndMaxPrice(@RequestParam("category") String categoryName, @RequestParam("max_price") Double maxPrice) {
        return productService.getProductsByCategoryNameAndMaxPrice(categoryName, maxPrice);
    }
}
