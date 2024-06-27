package edu.miu.waajune2024springdata.repository;

import edu.miu.waajune2024springdata.entity.Address;
import edu.miu.waajune2024springdata.entity.Product;
import edu.miu.waajune2024springdata.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * @author kush
 */
public interface ReviewRepository extends ListCrudRepository<Review,Long> {
    List<Review> findByProduct(Product product);
}
