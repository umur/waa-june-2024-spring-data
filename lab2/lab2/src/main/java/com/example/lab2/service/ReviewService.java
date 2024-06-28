package com.example.lab2.service;

import com.example.lab2.dto.ReviewDTO;
import com.example.lab2.entity.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getAll();

    ReviewDTO getById(Long id);

    Review getReviewById(Long id);

    ReviewDTO save(ReviewDTO review);

    ReviewDTO update(Long id, ReviewDTO review);

    boolean delete(Long id);

    List<ReviewDTO> findByProduct(Long productId);
}
