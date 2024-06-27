package miu.waa.lab3.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.lab3.entity.Review;
import miu.waa.lab3.repository.ReviewRepository;
import miu.waa.lab3.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        Review existReview = reviewRepository.findById(id).orElse(null);
        if(existReview == null) return null;
        existReview.setComment(review.getComment());
        return reviewRepository.save(existReview);
    }

    @Override
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> getReviewsByProductId(Long id) {
        return reviewRepository.findByProductId(id);
    }
}
