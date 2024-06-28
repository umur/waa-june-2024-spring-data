package com.waa.jpa.dao;

import com.waa.jpa.entities.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDAO extends ListCrudRepository<Review, Long> {

    List<Review> findReviewsByProductId(Long productId);
}
