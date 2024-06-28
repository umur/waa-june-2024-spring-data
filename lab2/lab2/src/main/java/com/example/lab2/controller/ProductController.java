package com.example.lab2.controller;

import com.example.lab2.dto.ProductDTO;
import com.example.lab2.dto.ReviewDTO;
import com.example.lab2.service.ProductService;
import com.example.lab2.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    private final ReviewService reviewService;


    @GetMapping("/price")
    public List<ProductDTO> findGreaterThanPrice(@RequestParam double minPrice){
        return service.findGreaterThanPrice(minPrice);
    }

    @GetMapping("/category-price")
    public List<ProductDTO> findInCategoryCostingLessThan(@RequestParam Long categoryId,@RequestParam double maxPrice){
        return service.findInCategoryCostingLessThan(categoryId,maxPrice);
    }

    @GetMapping("/search")
    public List<ProductDTO> findInCategoryCostingLessThan(@RequestParam String keyword){
        return service.findProductsLike(keyword);
    }


    @GetMapping
    public List<ProductDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO product){
        return service.save(product);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@RequestBody ProductDTO product,@PathVariable Long id){
        return service.update(id,product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }

    @GetMapping("{id}/review")
    public List<ReviewDTO> findByProduct(@PathVariable Long id){
        return reviewService.findByProduct(id);
    }
}
