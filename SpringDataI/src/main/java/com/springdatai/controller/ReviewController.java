package com.springdatai.controller;

import com.springdatai.service.DTO.ReviewDTO;
import com.springdatai.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public ReviewDTO createReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.createReview(reviewDTO);
    }

    @GetMapping("/{id}")
    public ReviewDTO getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }

    @PutMapping("/{id}")
    public ReviewDTO updateReview(@PathVariable int id, @RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReviewById(id, reviewDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReviewById(id);
    }

    @GetMapping("/filter/{id}")
    public List<ReviewDTO> getAllReviewsByProductId(@PathVariable int id){
        return reviewService.findAllReviewsByProductId(id);
    }
}
