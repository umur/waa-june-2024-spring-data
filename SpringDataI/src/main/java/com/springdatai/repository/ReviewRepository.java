package com.springdatai.repository;

import com.springdatai.domain.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review, Integer> {
    List<Review> findAllByProductId(int productId);
}
