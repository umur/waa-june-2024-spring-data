package edu.miu.cs545.lab3.lab3.controller;

import edu.miu.cs545.lab3.lab3.entity.Review;
import edu.miu.cs545.lab3.lab3.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
@Tag(name = "Review", description = "Review API")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Review findById(@PathVariable Long id) {
        return reviewService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void save(Review review) {
        reviewService.save(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Review review) {
        reviewService.update(review);
    }

    @GetMapping("/product/{productId}")
    public List<Review> findReviewsByProductId(@PathVariable Long productId) {
        return reviewService.findReviewsByProductId(productId);
    }
}
