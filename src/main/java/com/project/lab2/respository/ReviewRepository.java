package com.project.lab2.respository;

import com.project.lab2.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ReviewRepository extends ListCrudRepository<Review, Long> {
//    Optional<Review> findByReviewId(Long reviewId);
}
