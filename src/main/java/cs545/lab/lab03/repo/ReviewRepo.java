package cs545.lab.lab03.repo;

import cs545.lab.lab03.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {


    List<Review> findByProductId(int productId);
}
