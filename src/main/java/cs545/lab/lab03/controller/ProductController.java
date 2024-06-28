package cs545.lab.lab03.controller;

import cs545.lab.lab03.entity.Product;
import cs545.lab.lab03.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            Product updatedProduct = product.get();
            updatedProduct.setName(productDetails.getName());
            updatedProduct.setPrice(productDetails.getPrice());
            updatedProduct.setRating(productDetails.getRating());
            return ResponseEntity.ok(productService.addProduct(updatedProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/priceGreaterThan")
    public List<Product> getProductsByPriceGreaterThan(@RequestParam Double minPrice) {
        return productService.findByPriceGreaterThan(minPrice);
    }

    @GetMapping("/categoryAndPriceLessThan")
    public List<Product> getProductsByCategoryAndPriceLessThan(
            @RequestParam String category,
            @RequestParam Double maxPrice) {
        return productService.findByNameAndPriceLessThan(category, maxPrice);
    }

    @GetMapping("/nameContains")
    public List<Product> getProductsByNameContaining(@RequestParam String keyword) {
        return productService.findByNameContaining(keyword);
    }

}
