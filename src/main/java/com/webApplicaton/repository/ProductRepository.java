package com.webApplicaton.repository;

import com.webApplicaton.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByCategoryNameAndPriceLessThan(String category, Double price);
    List<Product> findByNameContainingIgnoreCase(String name);
}
