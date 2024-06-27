package com.example.demo.repository;

import com.example.demo.enity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findProductByPriceGreaterThan(double price);
    List<Product> findProductByCategoryNameAndPriceLessThan(String category, double price);
    List<Product> findProductByNameContaining(String keyword);
}
