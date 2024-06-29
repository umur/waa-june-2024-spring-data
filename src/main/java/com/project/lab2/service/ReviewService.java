package com.project.lab2.service;

import com.project.lab2.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();
    void save(Review review);
    void deleteByReviewId(Long id);
    Review update(Review review);
    Optional<Review> findReviewById(Long id);
}
