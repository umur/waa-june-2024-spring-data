package miu.waa.spring_demo.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Product;
import miu.waa.spring_demo.entity.Review;
import miu.waa.spring_demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() { return productService.getAll(); }

    @GetMapping("/filters/byPrice")
    public List<Product> findByPriceGreaterThan(@RequestParam("minPrice") double minPrice) {
        return productService.findByPriceGreaterThan(minPrice);
    }

    @GetMapping("/filters/byCategory_maxPrice")
    public List<Product> findByCategoryAndMaxPrice(
            @RequestParam("category") String category,
            @RequestParam("maxPrice") double maxPrice
    ) {
        return productService.findByCategoryAndMaxPrice(category, maxPrice);
    }

    @GetMapping("/filters/byName")
    public List<Product> findByNameContaining(@RequestParam("name") String name) {
        return productService.findByNameContaining(name);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @PostMapping("/{id}/reviews/users/{userId}")
    public Review addReview(@PathVariable int id, @RequestBody Review review, @PathVariable int userId) {
        return productService.addReview(id, review, userId);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.deleteById(id);
    }
}
