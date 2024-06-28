package lab2.pra.repository;

import lab2.pra.domain.Product;
import lab2.pra.domain.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepository extends ListCrudRepository<Review, Integer> {
    List<Review> findReviewsByProduct(Product product);
}
