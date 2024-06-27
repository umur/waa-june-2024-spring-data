package miu.waa.lab3.service;

import miu.waa.lab3.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(Long id);
    Review createReview(Review review);
    Review updateReview(Long id, Review review);
    void deleteReviewById(Long id);
    List<Review> getReviewsByProductId(Long id);
}
