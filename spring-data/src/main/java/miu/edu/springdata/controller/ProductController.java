package miu.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.Category;
import miu.edu.springdata.domain.Product;
import miu.edu.springdata.repository.ProductRepository;
import miu.edu.springdata.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(int productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping
    public void addProduct(Product product) {
        productService.addProduct(product);
    }
    @PutMapping
    public ResponseEntity<?> updateProduct(int id,Product product) {
        return ResponseEntity.ok(productService.updateProduct(id,product));
    }
    @DeleteMapping
    public void deleteProduct(int id) {
        productService.removeProduct(id);
    }
    @GetMapping("/price/{price}")
    public ResponseEntity<?> getProductsByPriceGreaterThan(@PathVariable double price) {
        return ResponseEntity.ok(productService.getProductsByPriceGreaterThan(price));
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable int categoryId) {
        return ResponseEntity.ok(productService.getReviewOfProduct(categoryId));
    }
    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> searchProduct(@PathVariable String keyword) {
        return ResponseEntity.ok(productService.getProductsByProductNameContains(keyword));
    }
    @GetMapping("/category/{categoryId}/price/{priceId}")
    public ResponseEntity<?> getProductByCategoryAndPrice(@PathVariable String Name, @PathVariable int priceId) {
        return ResponseEntity.ok(productService.getProductsByCategoryAndPriceLessThan(Name,priceId));
    }
}
