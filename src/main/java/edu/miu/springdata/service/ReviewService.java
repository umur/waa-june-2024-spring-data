package edu.miu.springdata.service;

import edu.miu.springdata.contract.ReviewResponse;
import edu.miu.springdata.contract.SaveReviewRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {
    Page<ReviewResponse> findAll(Pageable pageable);

    ReviewResponse findById(Long id);

    ReviewResponse save(SaveReviewRequest request);

    void deleteById(Long id);

    ReviewResponse updateReview(Long id, SaveReviewRequest request);
}
