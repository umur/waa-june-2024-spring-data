package com.example.springdata.reponsitory;

import com.example.springdata.model.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review,Long> {
    List<Review> findAllByProductId(Long productId);
}