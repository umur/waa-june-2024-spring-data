package com.example.Spring_Data.service;

import com.example.Spring_Data.entity.Review;
import com.example.Spring_Data.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(int id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(int id, Review reviewDetails) {
        Review review = getReviewById(id);
        review.setComment(reviewDetails.getComment());
        review.setUser(reviewDetails.getUser());
        review.setProduct(reviewDetails.getProduct());
        return reviewRepository.save(review);

    }
}
