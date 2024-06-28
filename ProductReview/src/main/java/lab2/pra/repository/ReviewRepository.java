package lab2.pra.repository;

import lab2.pra.domain.Product;
import lab2.pra.domain.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends ListCrudRepository<Review, Integer> {
    List<Review> findReviewsByProduct(Product product);
}
