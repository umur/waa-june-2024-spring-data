package com.example.lab2.repository;

import com.example.lab2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>
{
    List<Product> findByPriceGreaterThan(double minPrice);

    List<Product> findByCategory_IdAndPriceLessThan(Long categoryId, double price);

    List<Product> findByNameContainingIgnoreCase(String keyword);
}
