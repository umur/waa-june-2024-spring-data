package edu.miu.waajune2024springdata.controller;

import edu.miu.waajune2024springdata.dto.ProductDto;
import edu.miu.waajune2024springdata.dto.ReviewDto;
import edu.miu.waajune2024springdata.entity.Review;
import edu.miu.waajune2024springdata.service.ProductService;
import edu.miu.waajune2024springdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kush
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    private final ReviewService reviewService;


    @GetMapping("/price")
    public List<ProductDto> findGreaterThanPrice(@RequestParam double minPrice){
        return service.findGreaterThanPrice(minPrice);
    }

    @GetMapping("/category-price")
    public List<ProductDto> findInCategoryCostingLessThan(@RequestParam Long categoryId,@RequestParam double maxPrice){
        return service.findInCategoryCostingLessThan(categoryId,maxPrice);
    }

    @GetMapping("/keyword")
    public List<ProductDto> findInCategoryCostingLessThan(@RequestParam String keyword){
        return service.findProductsLike(keyword);
    }


    @GetMapping
    public List<ProductDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto product){
        return service.save(product);
    }

    @PutMapping("/{id}")
    public ProductDto update(@RequestBody ProductDto product,@PathVariable Long id){
        return service.update(id,product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }

    @GetMapping("{id}/review")
    public List<ReviewDto> findByProduct(@PathVariable Long id){
        return reviewService.findByProduct(id);
    }

}
