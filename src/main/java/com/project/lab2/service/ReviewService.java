package com.project.lab2.service;

import com.project.lab2.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();
    Review save(Review review);
    void deleteByReviewId(Long id);
    Review update(Review review, Long id);
    Optional<Review> findReviewById(Long id);
    List<Review> findAllReviewsByProductId(Long productId);
}
