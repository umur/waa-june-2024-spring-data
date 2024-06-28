package edu.miu.springdata.repository;

import edu.miu.springdata.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findDistinctFirstByCategoryId(Long categoryId);
}
