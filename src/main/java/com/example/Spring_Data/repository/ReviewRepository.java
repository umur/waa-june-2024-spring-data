package com.example.Spring_Data.repository;

import com.example.Spring_Data.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review, Integer> {
    List<Review> findAllByProduct_Id(int id);
}
