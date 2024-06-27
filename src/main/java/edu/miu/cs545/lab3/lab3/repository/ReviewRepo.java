package edu.miu.cs545.lab3.lab3.repository;

import edu.miu.cs545.lab3.lab3.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepo extends ListCrudRepository<Review, Long> {
    List<Review> findReviewsByProductId(Long productId);
}
