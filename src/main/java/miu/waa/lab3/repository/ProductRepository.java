package miu.waa.lab3.repository;

import miu.waa.lab3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(Double minPrice);
    List<Product> findByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice);
    List<Product> findByNameContaining(String name);
}
