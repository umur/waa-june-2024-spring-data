package com.example.springdata.repository;

import com.example.springdata.entity.Product;
import com.example.springdata.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
	List<Review> getReviewsByProductEquals(Product product);
}
