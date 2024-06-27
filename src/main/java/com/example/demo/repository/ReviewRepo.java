package com.example.demo.repository;

import com.example.demo.enity.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepo extends ListCrudRepository<Review, Long> {
    List<Review> findReviewByProductId(Long id);
}
