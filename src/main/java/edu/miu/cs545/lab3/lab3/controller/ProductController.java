package edu.miu.cs545.lab3.lab3.controller;

import edu.miu.cs545.lab3.lab3.entity.Product;
import edu.miu.cs545.lab3.lab3.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
@Tag(name = "Product", description = "Product API")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/")
    public void save(Product product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id).orElse(null);
    }

    @GetMapping("/priceGreaterThan/{price}")
    public List<Product> findByPriceGreaterThan(@PathVariable double price) {
        return productService.findByPriceGreaterThan(price);
    }

    @GetMapping("/categoryNameAndPriceLessThan/{categoryName}/{price}")
    public List<Product> findByCategoryNameAndPriceLessThan(@PathVariable String categoryName, @PathVariable double price) {
        return productService.findByCategoryNameAndPriceLessThan(categoryName, price);
    }

    @GetMapping("/nameContains/{name}")
    public List<Product> findByNameContains(@PathVariable String name) {
        return productService.findByNameContains(name);
    }
}
