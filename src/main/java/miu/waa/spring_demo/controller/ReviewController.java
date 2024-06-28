package miu.waa.spring_demo.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Product;
import miu.waa.spring_demo.entity.Review;
import miu.waa.spring_demo.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<Review> getAll() { return reviewService.getAll(); }

    @GetMapping("/{id}")
    public Review getById(@PathVariable int id) {
        return reviewService.getById(id);
    }

    @GetMapping("/filters/byProduct")
    public List<Review> findByProductId(@RequestParam("productId") int productId) {
        return reviewService.findByProductId(productId);
    }

    @PutMapping
    public Review update(@RequestBody Review review) {
        return reviewService.update(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewService.deleteById(id);
    }
}
