package com.springdatai.controller;

import com.springdatai.service.DTO.ProductDTO;
import com.springdatai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ProductDTO> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProductById(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        return productService.updateProductById(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/price-greater-than")
    public List<ProductDTO> getProductsByPriceGreaterThan(@RequestParam double minPrice) {
        return productService.findAllByPriceGreaterThan(minPrice);
    }

    @GetMapping("/category/price-less-than")
    public List<ProductDTO> getProductsByCategoryAndPriceLessThan(@RequestParam double maxPrice) {
        return productService.findAllByNameAndPriceLessThan(maxPrice);
    }

    @GetMapping("/name-contains")
    public List<ProductDTO> getProductsContainingKeyword() {
        return productService.findAllByNameContaining("keyword");
    }
}
