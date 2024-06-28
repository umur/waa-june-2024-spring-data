package miu.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.Review;
import miu.edu.springdata.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<?> getReview(int id) {
        return ResponseEntity.ok(reviewService.getReview(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllReview() {
        return ResponseEntity.ok(reviewService.getAllReview());
    }
    @PostMapping
    public void addReview(Review review) {
        reviewService.addReview(review);
    }
    @PutMapping
    public ResponseEntity<?> updateReview(int id, Review review) {
        return ResponseEntity.ok(reviewService.updateReview(id, review));
    }
    @DeleteMapping
    public void deleteReview(int id) {
        reviewService.deleteReview(id);
    }
}
