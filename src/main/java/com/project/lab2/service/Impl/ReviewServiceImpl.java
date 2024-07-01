package com.project.lab2.service.Impl;

import com.project.lab2.entity.Product;
import com.project.lab2.entity.Review;
import com.project.lab2.entity.User;
import com.project.lab2.respository.ProductRepository;
import com.project.lab2.respository.ReviewRepository;
import com.project.lab2.respository.UserRepository;
import com.project.lab2.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private static final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        log.info("review : {}", review.getUser());
        User user = userRepository.findById(review.getUser().getId()).orElse(null);
        Product product = productRepository.findById(review.getProduct().getId()).orElse(null);
        review.setUser(user);
        review.setProduct(product);
        return reviewRepository.save(review);

    }

    @Override
    public void deleteByReviewId(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review update(Review review, Long id) {
        Review oldReview = reviewRepository.findById(id).orElse(null);
        User user = userRepository.findById(review.getUser().getId()).orElse(null);
        Product product = productRepository.findById(review.getProduct().getId()).orElse(null);
        if (oldReview != null) {
            oldReview.setComment(review.getComment());
            oldReview.setUser(user);
            oldReview.setProduct(product);
            return reviewRepository.save(oldReview);
        } else {
            return null;
        }

    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAllReviewsByProductId(Long productId) {
        return reviewRepository.findAllByProduct_Id(productId).stream().filter(review -> review.getProduct().getId().equals(productId))
                .toList();
    }
}
