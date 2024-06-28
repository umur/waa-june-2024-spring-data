package com.waa.jpa.controller;

import com.waa.jpa.entities.Category;
import com.waa.jpa.entities.Product;
import com.waa.jpa.service.product.ProductService;
import com.waa.jpa.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends CrudController<Product, Long> {

    @Autowired
    private ProductService service;

    public ProductController(ProductServiceImpl service) {
        super(service);
    }

    @GetMapping("/filter1")
    public ResponseEntity<List<Product>> filterByMinPrice(@RequestParam double minPrice) {
        List<Product> products = service.filterProductsByMoreThanMinPrice(minPrice);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/filter2")
    public ResponseEntity<List<Product>> filterByCatAndMaxPrice(
            @RequestParam Category cat,
            @RequestParam double maxPrice
    ) {
        List<Product> products = service.filterProductsByCategoryAndLessThanMaxPrice(cat, maxPrice);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/filter3")
    public ResponseEntity<List<Product>> filterByKeyword(@RequestParam String keyword) {
        List<Product> products = service.filterProductsByName(keyword);
        return ResponseEntity.ok(products);
    }
}
