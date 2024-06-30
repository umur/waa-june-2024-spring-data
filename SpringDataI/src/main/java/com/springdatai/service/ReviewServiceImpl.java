package com.springdatai.service;

import com.springdatai.domain.Product;
import com.springdatai.domain.Review;
import com.springdatai.domain.User;
import com.springdatai.service.DTO.ReviewDTO;
import com.springdatai.repository.ProductRepository;
import com.springdatai.repository.ReviewRepository;
import com.springdatai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        if (reviewDTO == null) {
            throw new RuntimeException("Review should not be null");
        }

        Optional<Product> existingProduct = productRepository.findById(reviewDTO.getProductId());
        System.out.println(reviewDTO.getProductId() + "..................");
        Optional<User> existingUser = userRepository.findById(reviewDTO.getUserId());

        if (!existingProduct.isPresent()) {
            throw new RuntimeException("Product ID: " + reviewDTO.getProductId() + " is not found");
        }

        if (!existingUser.isPresent()) {
            throw new RuntimeException("User ID: " + reviewDTO.getUserId() + " is not found");
        }

        Review review = new Review();
        review.setComment(reviewDTO.getComment());
        review.setProduct(existingProduct.get());
        review.setUser(existingUser.get());

        Review savedReview = reviewRepository.save(review);
        return convertToDTO(savedReview);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(int id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty()) {
            throw new RuntimeException("Review ID: " + id + " is not found");
        }
        return convertToDTO(review.get());
    }

    @Override
    public ReviewDTO updateReviewById(int id, ReviewDTO reviewDTO) {
        Optional<Review> reviewCheck = reviewRepository.findById(id);
        if (reviewCheck.isEmpty()) {
            throw new RuntimeException("Review ID: " + id + " is not found");
        }

        Review review = reviewCheck.get();
        review.setComment(reviewDTO.getComment());

        Optional<Product> existingProduct = productRepository.findById(reviewDTO.getProductId());
        Optional<User> existingUser = userRepository.findById(reviewDTO.getUserId());

        if (!existingProduct.isPresent()) {
            throw new RuntimeException("Product ID: " + reviewDTO.getProductId() + " is not found");
        }

        if (!existingUser.isPresent()) {
            throw new RuntimeException("User ID: " + reviewDTO.getUserId() + " is not found");
        }

        review.setProduct(existingProduct.get());
        review.setUser(existingUser.get());

        Review updatedReview = reviewRepository.save(review);
        return convertToDTO(updatedReview);
    }

    @Override
    public void deleteReviewById(int id) {
        Optional<Review> reviewCheck = reviewRepository.findById(id);
        if (reviewCheck.isEmpty()) {
            throw new RuntimeException("Review ID: " + id + " is not found");
        }
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDTO> findAllReviewsByProductId(int productId) {
        List<Review> reviews = reviewRepository.findAllByProductId(productId);
        return reviews.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Review convertToEntity(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setId(reviewDTO.getId());
        review.setComment(reviewDTO.getComment());

        // Set user (assuming user ID is available in ReviewDTO)
        Optional<User> userOptional = userRepository.findById(reviewDTO.getUserId());
        userOptional.ifPresent(review::setUser);

        // Set product (assuming product ID is available in ReviewDTO)
        Optional<Product> productOptional = productRepository.findById(reviewDTO.getProductId());
        productOptional.ifPresent(review::setProduct);

        return review;
    }

    public ReviewDTO convertToDTO(Review review) {
        return new ReviewDTO(review.getId(), review.getComment(), review.getUser().getId(), review.getProduct().getId());
    }
}
