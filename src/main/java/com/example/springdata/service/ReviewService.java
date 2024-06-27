package com.example.springdata.service;

import com.example.springdata.entity.Product;
import com.example.springdata.entity.Review;
import com.example.springdata.entity.User;
import com.example.springdata.repository.ProductRepository;
import com.example.springdata.repository.ReviewRepository;
import com.example.springdata.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
	private final ReviewRepository reviewRepository;
	private final ProductRepository productRepository;
	private final UserRepository userRepository;

	public List<Review> getAll() {
		return reviewRepository.findAll();
	}

	public Review createOne(Review review, String productId, String userId) throws Exception {
		Product product = productRepository.findById(productId).orElseThrow(() -> new Exception("Product not found!"));
		User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found!"));
		review.setProduct(product);
		review.setUser(user);
		return reviewRepository.save(review);
	}

	public Optional<Review> updateOne(String id, Review review) {
		Review item = reviewRepository.findById(id).orElse(null);
		if (item == null) {
			return Optional.empty();
		}
		item.setComment(review.getComment());
		return Optional.of(reviewRepository.save(item));
	}

	public Optional<Review> deleteOne(String id) {
		Review item = reviewRepository.findById(id).orElse(null);
		if (item == null) {
			return Optional.empty();
		}
		reviewRepository.deleteById(id);
		return Optional.of(item);
	}

	public List<Review> getReviewsByProductEquals(String productId) {
		Product product = productRepository.findById(productId).orElse(null);
		if (product == null) {
			return List.of();
		}
		return reviewRepository.getReviewsByProductEquals(product);
	}
}
