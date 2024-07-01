package com.project.lab2.controller;

import com.project.lab2.entity.Review;
import com.project.lab2.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/product/{productId}")
    public List<Review> getProductReviews(@PathVariable Long productId) {
        return reviewService.findAllReviewsByProductId(productId);
    }
    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable Long id) {
        return reviewService.findReviewById(id);
    }

    @PostMapping
    public Review  addReview(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @DeleteMapping("/{id}")
    public void  deleteReview(@PathVariable Long id) {
        reviewService.deleteByReviewId(id);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.update(review, id);
    }

}
