package com.example.lab2.repository;

import com.example.lab2.entity.Product;
import com.example.lab2.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByProduct(Product product);
}
