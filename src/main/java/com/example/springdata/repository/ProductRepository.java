package com.example.springdata.repository;

import com.example.springdata.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	List<Product> getProductsByPriceGreaterThan(Double price);
	List<Product> getProductsByNameContains(String keyword);
	List<Product> getProductsByCategoryIdAndPriceLessThan(String categoryId, Double maxPrice);
}
