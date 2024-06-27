package waa.springdata.repository;

import org.springframework.data.repository.ListCrudRepository;
import waa.springdata.entity.Review;

import java.util.List;

public interface ReviewRepository extends ListCrudRepository<Review,Integer> {
    List<Review> findByProductId(int productId);
}
