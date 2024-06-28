package edu.miu.springdata.repository;

import edu.miu.springdata.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findDistinctFirstByCategoryId(Long categoryId);

    Page<Product> findAllByPriceGreaterThanEqual(BigDecimal price, Pageable pageable);

    Page<Product> findAllByPriceLessThanEqualAndCategoryId(BigDecimal price, Long categoryId, Pageable pageable);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
