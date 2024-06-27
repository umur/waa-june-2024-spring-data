package com.example.demo.service;

import com.example.demo.enity.Product;
import com.example.demo.enity.Review;
import com.example.demo.enity.User;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ReviewRepo;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepo.findById(id).orElse(null);
    }

    public Review addReview(Review review) {
        Product product = productRepo.findById(review.getProduct().getId()).orElse(null);
        User user = userRepo.findById(review.getUser().getId()).orElse(null);
        review.setProduct(product);
        review.setUser(user);
        Review newReview = reviewRepo.save(review);
        List<Review> reviews = product.getReviews();
        reviews.add(newReview);
        product.setReviews(reviews);
        productRepo.save(product);
        return newReview;
    }

    public Review updateReview(Long id, Review review) {
        Review existingReview = reviewRepo.findById(id).orElse(null);
        if (existingReview != null) {
            if (review.getUser() != null) {
                User user = userRepo.findById(review.getUser().getId()).orElse(null);
                existingReview.setUser(user);
            }
            if (review.getProduct() != null) {
                Product product = productRepo.findById(review.getProduct().getId()).orElse(null);
                existingReview.setProduct(product);
            }
            existingReview.setComment(review.getComment());
            return reviewRepo.save(existingReview);
        } else {
            return null;
        }
    }

    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }

    public List<Review> getReviewsByProductId(Long id) {
        return reviewRepo.findReviewByProductId(id);
    }
}
