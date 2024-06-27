package com.example.springdata.controller;

import com.example.springdata.entity.Review;
import com.example.springdata.model.CreateOrUpdateReviewRequest;
import com.example.springdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
	private final ReviewService reviewService;

	@GetMapping
	public ResponseEntity<List<Review>> getAll() {
		return ResponseEntity.ok().body(reviewService.getAll());
	}

	@PostMapping
	public ResponseEntity<?> createOne(@RequestBody CreateOrUpdateReviewRequest req) {
		try {
			Review resp = reviewService.createOne(req.getReview(), req.getProductId(), req.getUserId());
			return ResponseEntity.ok().body(resp);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody CreateOrUpdateReviewRequest req, @PathVariable String id) {
		Optional<Review> resp = reviewService.updateOne(id, req.getReview());
		if (resp.isEmpty()) {
			return ResponseEntity.badRequest().body("Review ID not found!");
		}
		return ResponseEntity.ok().body(resp);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		Optional<Review> deletedItem = reviewService.deleteOne(id);
		if (deletedItem.isEmpty()) {
			return ResponseEntity.badRequest().body("Review ID not found!");
		}
		return ResponseEntity.ok().body(deletedItem);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<?> getReviewsByProductEquals(@PathVariable String productId) {
		return ResponseEntity.ok(reviewService.getReviewsByProductEquals(productId));
	}
}
