package edu.miu.springdata.controller;

import edu.miu.springdata.contract.ReviewResponse;
import edu.miu.springdata.contract.SaveReviewRequest;
import edu.miu.springdata.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Reviews", description = "Operations related to product reviews.")
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Operation(description = "Get all reviews in a manageable way.")
    @GetMapping
    public ResponseEntity<Page<ReviewResponse>> getAllReviews(Pageable pageable) {
        return ResponseEntity.ok(reviewService.findAll(pageable));
    }

    @Operation(description = "Get review by id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @GetMapping("/{review-id}")
    public ResponseEntity<ReviewResponse> getReviewById(@PathVariable("review-id") Long id) {
        return ResponseEntity.ok(reviewService.findById(id));
    }

    @Operation(description = "Add a review.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404")})
    @PostMapping
    public ResponseEntity<ReviewResponse> addReview(@RequestBody SaveReviewRequest request) {
        return new ResponseEntity<>(reviewService.save(request), HttpStatus.CREATED);
    }

    @Operation(description = "Update review by id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @PutMapping("/{review-id}")
    public ResponseEntity<ReviewResponse> updateReview(
            @PathVariable("review-id") Long id,
            @RequestBody SaveReviewRequest request
                                                      ) {
        return ResponseEntity.ok(reviewService.updateReview(id, request));
    }

    @Operation(description = "Delete review by id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "204"), @ApiResponse(responseCode = "404")})
    @DeleteMapping("/{review-id}")
    public ResponseEntity<Void> deleteReview(@PathVariable("review-id") Long id) {
        reviewService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
