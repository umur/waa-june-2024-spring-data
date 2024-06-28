package miu.edu.springdata.service;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.Review;
import miu.edu.springdata.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    public void addReview(Review review) {
        reviewRepository.save(review);
    }
    public Review updateReview(int id, Review review) {
        Review review1 = reviewRepository.findById(id).orElse(null);
        if (review1 == null) {
            throw new IllegalArgumentException("Review not found");
        }
        review1.setComment(review.getComment());
        return reviewRepository.save(review1);

    }
    public void deleteReview(int id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review == null) {
            throw new IllegalArgumentException("Review not found");
        }
        reviewRepository.delete(review);
    }
    public Review getReview(int id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review == null) {
            throw new IllegalArgumentException("Review not found");
        }
        return review;
    }
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }
}
