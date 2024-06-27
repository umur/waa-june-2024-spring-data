package com.springdatai.service;

import com.springdatai.domain.Review;
import com.springdatai.service.DTO.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO createReview(ReviewDTO reviewDTO);

    List<ReviewDTO> getAllReviews();

    ReviewDTO getReviewById(int id);

    ReviewDTO updateReviewById(int id, ReviewDTO reviewDTO);

    void deleteReviewById(int id);

    Review convertToEntity(ReviewDTO reviewDTO);

    ReviewDTO convertToDTO(Review review);

    List<ReviewDTO> findAllReviewsByProductId(int productId);
}
