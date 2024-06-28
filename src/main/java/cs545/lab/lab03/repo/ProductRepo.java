package cs545.lab.lab03.repo;

import cs545.lab.lab03.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByPriceGreaterThan(double minPrice);

    List<Product> findByNameContaining(String keyword);
}
