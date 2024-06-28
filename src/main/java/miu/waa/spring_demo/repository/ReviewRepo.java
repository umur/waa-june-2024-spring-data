package miu.waa.spring_demo.repository;

import miu.waa.spring_demo.entity.Product;
import miu.waa.spring_demo.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepo extends ListCrudRepository<Review, Integer> {
    List<Review> findByProductId(int productId);
}
