package com.example.springdata.service_implement;

import com.example.springdata.model.Review;
import com.example.springdata.reponsitory.ReviewRepository;
import com.example.springdata.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImplement implements ReviewService {
    private final ReviewRepository reviewRepository;
    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Long id, Review review) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);

        if(reviewOptional.isPresent()) {
            Review newReview = reviewOptional.get();
            newReview.setComment(review.getComment());
            return reviewRepository.save(newReview);
        }
        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findAllByProductId(Long productId) {
        return reviewRepository.findAllByProductId(productId);
    }
}
