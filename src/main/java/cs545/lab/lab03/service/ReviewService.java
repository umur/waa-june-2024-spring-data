package cs545.lab.lab03.service;

import cs545.lab.lab03.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review addReview(Review review);

    List<Review> getAllReviews();

    Optional<Review> getReviewById(int id);

    void deleteReview(int id);

    List<Review> findByProductId(int productId);

}
