package com.waa.jpa.dao;

import com.waa.jpa.entities.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDAO extends ListCrudRepository<Review, Long> {
}
