package com.webApplicaton.controller;

import com.webApplicaton.entity.Review;
import com.webApplicaton.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public void save(@RequestBody Review review) {
        reviewService.save(review);
    }

    @GetMapping
    public List<Review> getAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Review getById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody Review review) {
        reviewService.update(id, review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }

    @GetMapping("/comment/{userId}")
    public List<Review> getReviewsByProductId(@PathVariable Long userId) {
        return reviewService.findAllByUserId(userId);
    }
}
